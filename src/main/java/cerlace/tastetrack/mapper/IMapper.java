package cerlace.tastetrack.mapper;

import java.util.List;

public interface IMapper<DtoT, EntityT> {
    /**
     * Метод конвертирует {@code Entity} в {@code DTO}
     *
     * @param entity входной объект типа {@code Entity}
     * @return объект типа {@code DTO}
     */
    DtoT toDTO(EntityT entity);
    /**
     * Метод конвертирует {@code DTO} в {@code Entity}
     *
     * @param dto входной объект типа {@code DTO}
     * @return объект типа {@code Entity}
     */
    EntityT toEntity(DtoT dto);
    /**
     * Метод конвертирует список объектов {@code Entity} в
     * список объектов {@code DTO}
     *
     * @param entityList входной список объектов типа {@code Entity}
     * @return список объектов типа {@code DTO}
     */
    List<DtoT> toDTOList(List<EntityT> entityList);
    /**
     * Метод конвертирует список объектов{@code DTO} в
     * список объектов {@code Entity}
     *
     * @param dtoList входной список объектов типа {@code DTO}
     * @return список объектов типа {@code Entity}
     */
    List<EntityT> toEntityList(List<DtoT> dtoList);
}
