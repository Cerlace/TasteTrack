package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.DishFilter;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.entity.DishEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DishService {
    /**
     * Конвертирует {@link DishDTO} в {@link DishEntity}
     * и передает на слой Repository для сохранения или обновления.
     *
     * @param dto {@link DishDTO}, который нужно записать в БД
     * @return записанный в БД {@link DishDTO} с id
     */
    DishDTO saveOrUpdate(DishDTO dto);

    /**
     * Получает из слоя Repository объект {@link DishEntity} по id и
     * конвертирует его в объект {@link DishDTO}.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    DishDTO get(Long id);

    /**
     * Получает из слоя Repository объект {@link DishEntity} по id и
     * конвертирует его в объект {@link DishDTO}.
     * Включает в возвращаемый объект набор ингредиентов блюда.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    DishDTO getDetailed(Long id);

    /**
     * Получает из слоя Repository список всех объектов {@link DishEntity} в БД,
     * конвертирует их в объекты {@link DishDTO}.
     *
     * @return список объектов {@link DishDTO}
     */
    List<DishDTO> getAll();

    /**
     * Получает из слоя Repository страницу объектов {@link DishEntity},
     * отфильтрованную по критериям и конвертирует их в объекты {@link DishDTO}.
     *
     * @param pageSettings объект содержащий параметры страницы.
     * @param filter   объект содержащий параметры фильтрации блюд.
     * @return страница объектов {@link DishDTO}
     */
    Page<DishDTO> getFilteredPage(PageSettings pageSettings, DishFilter filter);

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     *           или не произошло удаление
     */
    void delete(Long id);
}
