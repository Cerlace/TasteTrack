package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.entity.MealEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MealService {
    /**
     * Конвертирует {@link MealDTO} в {@link MealEntity}
     * и передает на слой Repository для сохранения или обновления.
     *
     * @param dto {@link MealDTO}, который нужно записать в БД
     * @return записанный в БД {@link MealDTO} с id
     */
    MealDTO saveOrUpdate(MealDTO dto);

    /**
     * Получает из слоя Repository объект {@link MealEntity} по id и
     * конвертирует его в объект {@link MealDTO}.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    MealDTO get(Long id);

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     *           или не произошло удаление
     */
    void delete(Long id);

    /**
     * Получает все {@code MealDTO}, которые относятся к пользователю
     *
     * @param userId идентификатор пользователя
     * @return список приемов пищи в формате {@code List<MealDTO>}
     */
    List<MealDTO> getMealsByUser(Long userId);

    /**
     * Получает страницу {@code MealDTO}, которые относятся к пользователю
     *
     * @param pageSettings объект содержащий параметры страницы.
     * @param userId       идентификатор пользователя.
     * @return страница объектов {@link DishIngredientDTO}
     */
    Page<MealDTO> getPageOfMealsByUser(PageSettings pageSettings, Long userId);
}
