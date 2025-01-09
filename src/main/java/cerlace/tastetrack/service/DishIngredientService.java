package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.entity.DishIngredientPK;

import java.util.List;

public interface DishIngredientService {
    /**
     * Конвертирует DTO в Entity
     * и передает на слой DAO для сохранения.
     *
     * @param dto DTO, который нужно записать в БД
     * @return записанный в БД объект с id
     */
    DishIngredientDTO save(DishIngredientDTO dto);

    /**
     * Получает из слоя DAO объект Entity по id и
     * конвертирует его в объект DTO.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    DishIngredientDTO get(DishIngredientPK id);

    /**
     * Получает из слоя DAO список всех объектов Entity в БД,
     * конвертирует их в объекты DTO.
     *
     * @return список объектов DTO
     */
    List<DishIngredientDTO> getAll();


    /**
     * С помощью слоя DAO инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     * @return true, если запись удалена, false, если запись не была найдена
     * или не произошло удаление
     */
    boolean delete(DishIngredientPK id);

    /**
     * Закрывает EntityManager у объекта DAO
     */
    void closeDao();
}
