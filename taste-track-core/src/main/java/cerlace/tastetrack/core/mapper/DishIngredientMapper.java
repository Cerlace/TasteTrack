package cerlace.tastetrack.core.mapper;

import cerlace.tastetrack.core.dto.DishIngredientDTO;
import cerlace.tastetrack.persistence.entity.DishIngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {DishMapper.class, IngredientMapper.class})
public interface DishIngredientMapper {
    DishIngredientMapper INSTANCE = Mappers.getMapper(DishIngredientMapper.class);

    /**
     * Метод конвертирует {@code Entity} в {@code DTO}
     *
     * @param entity входной объект типа {@code Entity}
     * @return объект типа {@code DTO}
     */
    DishIngredientDTO toDTO(DishIngredientEntity entity);

    /**
     * Метод конвертирует {@code DTO} в {@code Entity}
     *
     * @param dto входной объект типа {@code DTO}
     * @return объект типа {@code Entity}
     */
    DishIngredientEntity toEntity(DishIngredientDTO dto);

    /**
     * Метод конвертирует список объектов {@code Entity} в
     * список объектов {@code DTO}
     *
     * @param entityList входной список объектов типа {@code Entity}
     * @return список объектов типа {@code DTO}
     */
    List<DishIngredientDTO> toDTOList(List<DishIngredientEntity> entityList);

    /**
     * Метод конвертирует список объектов{@code DTO} в
     * список объектов {@code Entity}
     *
     * @param dtoList входной список объектов типа {@code DTO}
     * @return список объектов типа {@code Entity}
     */
    List<DishIngredientEntity> toEntityList(List<DishIngredientDTO> dtoList);

    /**
     * Метод конвертирует набор объектов {@code Entity} в
     * набор объектов {@code DTO}
     *
     * @param entitySet входной набор объектов типа {@code Entity}
     * @return набор объектов типа {@code DTO}
     */
    Set<DishIngredientDTO> toDTOSet(Set<DishIngredientEntity> entitySet);
}
