package cerlace.tastetrack.core.mapper;

import cerlace.tastetrack.core.dto.IngredientDTO;
import cerlace.tastetrack.persistence.entity.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    /**
     * Метод конвертирует {@code Entity} в {@code DTO}
     *
     * @param entity входной объект типа {@code Entity}
     * @return объект типа {@code DTO}
     */
    IngredientDTO toDTO(IngredientEntity entity);

    /**
     * Метод конвертирует {@code DTO} в {@code Entity}
     *
     * @param dto входной объект типа {@code DTO}
     * @return объект типа {@code Entity}
     */
    IngredientEntity toEntity(IngredientDTO dto);

    /**
     * Метод конвертирует список объектов {@code Entity} в
     * список объектов {@code DTO}
     *
     * @param entityList входной список объектов типа {@code Entity}
     * @return список объектов типа {@code DTO}
     */
    List<IngredientDTO> toDTOList(List<IngredientEntity> entityList);
}
