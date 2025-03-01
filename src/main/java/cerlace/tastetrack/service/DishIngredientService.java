package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.entity.DishIngredientEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DishIngredientService {
    /**
     * Конвертирует {@link DishIngredientDTO} в {@link DishIngredientEntity}
     * и передает на слой Repository для сохранения или обновления.
     *
     * @param dto {@link DishIngredientDTO}, который нужно записать в БД
     * @return записанный в БД {@link DishIngredientDTO} с id
     */
    DishIngredientDTO saveOrUpdate(DishIngredientDTO dto);

    /**
     * Получает из слоя Repository объект {@link DishIngredientEntity} по id и
     * конвертирует его в объект {@link DishIngredientDTO}.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    DishIngredientDTO get(Long id);

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     *           или не произошло удаление
     */
    void delete(Long id);

    /**
     * Получает все {@code DishIngredientDTO}, которые относятся к блюду
     *
     * @param dishId идентификатор блюда.
     * @return список ингредиентов в формате {@code List<DishIngredientDTO>}
     */
    List<DishIngredientDTO> getIngredientsByDish(Long dishId);

    /**
     * Получает страницу {@code DishIngredientDTO}, которые относятся к блюду.
     *
     * @param pageSettings объект содержащий параметры страницы.
     * @param dishId       идентификатор блюда.
     * @return страница объектов {@link DishIngredientDTO}
     */
    Page<DishIngredientDTO> getPageOfIngredientsByDish(PageSettings pageSettings, Long dishId);
}

