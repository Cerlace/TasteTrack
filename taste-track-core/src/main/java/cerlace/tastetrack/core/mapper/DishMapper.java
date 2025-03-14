package cerlace.tastetrack.core.mapper;

import cerlace.tastetrack.core.dto.DishDTO;
import cerlace.tastetrack.persistence.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);

    /**
     * Метод конвертирует {@code Entity} в {@code DTO}
     * игнорируя поле с набором для избежания цикличности.
     *
     * @param entity входной объект типа {@code Entity}
     * @return объект типа {@code DTO}
     */
    @Mapping(target = "dishIngredients", ignore = true)
    DishDTO toDTO(DishEntity entity);

    /**
     * Метод конвертирует {@code DTO} в {@code Entity}
     * игнорируя поле с набором для избежания цикличности.
     *
     * @param dto входной объект типа {@code DTO}
     * @return объект типа {@code Entity}
     */
    @Mapping(target = "dishIngredients", ignore = true)
    DishEntity toEntity(DishDTO dto);

    /**
     * Метод конвертирует список объектов {@code Entity} в
     * список объектов {@code DTO}
     *
     * @param entityList входной список объектов типа {@code Entity}
     * @return список объектов типа {@code DTO}
     */
    List<DishDTO> toDTOList(List<DishEntity> entityList);
}
