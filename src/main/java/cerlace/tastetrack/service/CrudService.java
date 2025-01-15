package cerlace.tastetrack.service;

import java.util.List;

public interface CrudService<DtoT> {
    /**
     * Конвертирует DTO в Entity
     * и передает на слой DAO для сохранения.
     * @param dto DTO, который нужно записать в БД
     * @return записанный в БД объект с id
     */
    DtoT save(DtoT dto);

    /**
     * Получает из слоя DAO объект Entity по id и
     * конвертирует его в объект DTO.
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    DtoT get(Long id);

    /**
     * Получает из слоя DAO список всех объектов Entity в БД,
     * конвертирует их в объекты DTO.
     * @return список объектов DTO
     */
    List<DtoT> getAll();

    /**
     * Конвертирует DTO в Entity и передает
     * на слой DAO для обновления записи в БД
     * @param dto DTO, который нужно обновить в БД
     * @param id идентификатор записи в БД
     * @return обновленный в БД объект
     */
    DtoT update(Long id, DtoT dto);

    /**
     * С помощью слоя DAO инициирует удаление объекта из БД
     * @param id идентификатор записи для удаления
     * @return true, если запись удалена, false, если запись не была найдена
     * или не произошло удаление
     */
    boolean delete(Long id);

    /**
     * Закрывает EntityManager у объекта DAO
     */
    void closeDao();
}
