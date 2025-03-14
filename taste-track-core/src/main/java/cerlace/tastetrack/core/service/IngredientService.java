package cerlace.tastetrack.core.service;

import cerlace.tastetrack.core.dto.IngredientDTO;
import cerlace.tastetrack.core.dto.PageSettings;
import cerlace.tastetrack.persistence.entity.IngredientEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IngredientService {
    /**
     * Конвертирует {@link IngredientDTO} в {@link IngredientEntity}
     * и передает на слой Repository для сохранения или обновления.
     *
     * @param dto {@link IngredientDTO}, который нужно записать в БД
     * @return записанный в БД {@link IngredientDTO} с id
     */
    IngredientDTO saveOrUpdate(IngredientDTO dto);

    /**
     * Получает из слоя Repository объект {@link IngredientEntity} по id и
     * конвертирует его в объект {@link IngredientDTO}.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    IngredientDTO get(Long id);

    /**
     * Получает из слоя Repository список всех объектов {@link IngredientEntity} в БД,
     * конвертирует их в объекты {@link IngredientDTO}.
     *
     * @return список объектов {@link IngredientDTO}
     */
    List<IngredientDTO> getAll();

    /**
     * Получает из слоя Repository страницу объектов {@link IngredientEntity} в БД,
     * конвертирует их в объекты {@link IngredientDTO}.
     *
     * @param pageSettings объект содержащий параметры страницы.
     * @return страница объектов {@link IngredientDTO}
     */
    Page<IngredientDTO> getPage(PageSettings pageSettings);

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     *           или не произошло удаление
     */
    void delete(Long id);
}
