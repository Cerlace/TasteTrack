package cerlace.tastetrack.service;

import java.util.List;

public interface CrudService<DtoT> {
    /**
     * Конвертирует DTO в Entity
     * и передает на слой Repository для сохранения или обновления.
     * @param dto DTO, который нужно записать в БД
     * @return записанный в БД объект с id
     */
    DtoT saveOrUpdate(DtoT dto);

    /**
     * Получает из слоя Repository объект Entity по id и
     * конвертирует его в объект DTO.
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    DtoT get(Long id);

    /**
     * Получает из слоя Repository список всех объектов Entity в БД,
     * конвертирует их в объекты DTO.
     * @return список объектов DTO
     */
    List<DtoT> getAll();

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     * @param id идентификатор записи для удаления
     * или не произошло удаление
     */
    void delete(Long id);
}
