package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.DietDiaryDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.entity.MealEntity;
import cerlace.tastetrack.entity.UserEntity;
import cerlace.tastetrack.enums.MealTime;
import cerlace.tastetrack.mapper.MealMapper;
import cerlace.tastetrack.repository.MealRepository;
import cerlace.tastetrack.repository.UserRepository;
import cerlace.tastetrack.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;
    private final MealMapper mealMapper;

    @Override
    public MealDTO saveOrUpdate(MealDTO dto) {
        MealEntity entity = mealMapper.toEntity(dto);
        return mealMapper.toDTO(mealRepository.save(entity));
    }

    @Override
    public MealDTO get(Long id) {
        return mealRepository.findById(id)
                .map(mealMapper::toDTO)
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        mealRepository.deleteById(id);
    }

    @Override
    public List<MealDTO> getMealsByUser(Long userId) {
        return mealMapper.toDTOList(mealRepository.findByUserId(userId));
    }

    @Override
    public Page<MealDTO> getPageOfMealsByUser(PageSettings pageSettings, Long userId) {
        Pageable pageable = PageRequest.of(
                pageSettings.getPage(),
                pageSettings.getSize(),
                Sort.by(Sort.Direction.fromString(
                        pageSettings.getSortDirection()), pageSettings.getSortField()));

        return mealRepository.findByUserId(pageable, userId).map(mealMapper::toDTO);
    }

    /**
     * Возвращает дневник диеты для указанного пользователя за неделю,
     * указанной даты или с текущей недели, если дата не указана.
     *
     * @param username  имя пользователя, для которого создается дневник диеты
     * @param inputDate дата, определяющая неделю; если null, используется понедельник текущей недели
     * @return объект {@link DietDiaryDTO}, содержащий:
     * - суточную норму калорий для пользователя
     * - список дат недели
     * - приемы пищи, сгруппированные по дате и времени приема
     * - общее количество калорий, потребленных за каждый день недели
     */
    @Override
    public DietDiaryDTO getDietDiary(String username, LocalDate inputDate) {

        LocalDate startDate = (inputDate != null) ? inputDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                : LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        LocalDate endDate = startDate.plusDays(6);
        List<MealEntity> meals = mealRepository.findByUserUsernameAndDateBetween(username, startDate, endDate);

        Map<LocalDate, Map<MealTime, List<MealDTO>>> groupedMeals = meals.stream()
                .map(mealMapper::toDTO)
                .collect(Collectors.groupingBy(MealDTO::getDate,
                        Collectors.groupingBy(MealDTO::getMealTime)));

        List<LocalDate> weekDates = Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(7)
                .toList();

        Map<LocalDate, Double> caloriesByDate = meals.stream()
                .collect(Collectors.groupingBy(
                        MealEntity::getDate,
                        Collectors.summingDouble(meal -> meal.getDish().getCalories())
                ));

        UserEntity user = userRepository.findByUsername(username);

        return DietDiaryDTO.builder()
                .startDate(startDate)
                .dailyLimit(calculateDailyCalories(user))
                .weekDates(weekDates)
                .groupedMeals(groupedMeals)
                .caloriesByDate(caloriesByDate)
                .build();
    }

    /**
     * Рассчитывает необходимый дневной уровень калорий по формуле Миффлина-Сан Жеора
     *
     * @param user пользователь
     * @return дневная норма калорий в питании.
     */
    public int calculateDailyCalories(UserEntity user) {
        int userAge = Period.between(user.getBirthDate(), LocalDate.now()).getYears();
        double bmr = switch (user.getGender()) {
            case MALE -> 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * userAge + 5;
            case FEMALE -> 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * userAge - 161;
        };
        return (int) Math.round(bmr * user.getActivity().getMultiplier()) +
                user.getGoal().getCaloriesCorrection();
    }
}
