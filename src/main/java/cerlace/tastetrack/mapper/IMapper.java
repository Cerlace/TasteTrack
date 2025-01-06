package cerlace.tastetrack.mapper;

import java.util.List;

public interface IMapper<T, E> {
    /**
     * Метод конвертирует {@code Entity} в {@code DTO}
     *
     * @param entity входной объект типа {@code Entity}
     * @return объект типа {@code DTO}
     */
    T toDTO(E entity);
    /**
     * Метод конвертирует {@code DTO} в {@code Entity}
     *
     * @param dto входной объект типа {@code DTO}
     * @return объект типа {@code Entity}
     */
    E toEntity(T dto);
    /**
     * Метод конвертирует список объектов {@code Entity} в
     * список объектов {@code DTO}
     *
     * @param entityList входной список объектов типа {@code Entity}
     * @return список объектов типа {@code DTO}
     */
    List<T> toDTOList(List<E> entityList);
    /**
     * Метод конвертирует список объектов{@code DTO} в
     * список объектов {@code Entity}
     *
     * @param dtoList входной список объектов типа {@code DTO}
     * @return список объектов типа {@code Entity}
     */
    List<E> toEntityList(List<T> dtoList);
}
