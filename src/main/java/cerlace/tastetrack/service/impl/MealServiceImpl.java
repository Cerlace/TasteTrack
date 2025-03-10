package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.DietDiaryDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.entity.MealEntity;
import cerlace.tastetrack.entity.UserEntity;
import cerlace.tastetrack.enums.MealTime;
import cerlace.tastetrack.mapper.MealMapper;
import cerlace.tastetrack.repository.MealRepository;
import cerlace.tastetrack.repository.UserRepository;
import cerlace.tastetrack.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public static final int DAYS_IN_WEEK = 7;
    public static final int ONE_DAY = 1;
    public static final int SIX_DAYS = 6;
    public static final int WEIGHT_MULTIPLIER = 10;
    public static final double HEIGHT_MULTIPLIER = 6.25;
    public static final int AGE_MULTIPLIER = 5;
    public static final int MALE_CORRECTION_VALUE = 5;
    public static final int FEMALE_CORRECTION_VALUE = -161;

    private final MealRepository mealRepository;
    private final UserRepository userRepository;
    private final MealMapper mealMapper;

    @Override
    public MealDTO save(MealDTO dto) {
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

    @Transactional(readOnly = true)
    @Override
    public DietDiaryDTO getDietDiary(String username, LocalDate inputDate) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow();

        LocalDate startDate = (inputDate != null) ? inputDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                : LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        LocalDate endDate = startDate.plusDays(SIX_DAYS);
        List<MealEntity> meals = mealRepository.findByUserUsernameAndDateBetween(username, startDate, endDate);

        Map<LocalDate, Map<MealTime, List<MealDTO>>> groupedMeals = meals.stream()
                .map(mealMapper::toDTO)
                .collect(Collectors.groupingBy(MealDTO::getDate,
                        Collectors.groupingBy(MealDTO::getMealTime)));

        List<LocalDate> weekDates = Stream.iterate(startDate, date -> date.plusDays(ONE_DAY))
                .limit(DAYS_IN_WEEK)
                .toList();

        Map<LocalDate, Integer> caloriesByDate = meals.stream()
                .collect(Collectors.groupingBy(
                        MealEntity::getDate,
                        Collectors.summingInt(meal -> meal.getDish().getCalories().intValue())
                ));

        return DietDiaryDTO.builder()
                .username(username)
                .startDate(startDate)
                .dailyLimit(calculateDailyCalories(user))
                .weekDates(weekDates)
                .groupedMeals(groupedMeals)
                .caloriesByDate(caloriesByDate)
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public DietDiaryDTO getDietDiary(Long userId, LocalDate date) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        return getDietDiary(user.getUsername(), date);
    }

    /**
     * Рассчитывает необходимый дневной уровень калорий по формуле Миффлина-Сан Жеора
     *
     * @param user пользователь
     * @return дневная норма калорий в питании.
     */
    private int calculateDailyCalories(UserEntity user) {
        int userAge = Period.between(user.getBirthDate(), LocalDate.now()).getYears();
        int correctionValue = switch (user.getGender()) {
            case MALE -> MALE_CORRECTION_VALUE;
            case FEMALE -> FEMALE_CORRECTION_VALUE;
        };
        double bmr = WEIGHT_MULTIPLIER * user.getWeight()
                + HEIGHT_MULTIPLIER * user.getHeight()
                - AGE_MULTIPLIER * userAge + correctionValue;
        return (int) Math.round(bmr * user.getActivity().getMultiplier()) +
                user.getGoal().getCaloriesCorrection();
    }
}
