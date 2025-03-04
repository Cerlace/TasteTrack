package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {DishMapper.class, IngredientMapper.class})
public interface DishIngredientMapper extends IMapper<DishIngredientDTO, DishIngredientEntity> {
    DishIngredientMapper INSTANCE = Mappers.getMapper(DishIngredientMapper.class);

    /**
     * Метод конвертирует набор объектов {@code Entity} в
     * набор объектов {@code DTO}
     *
     * @param entitySet входной набор объектов типа {@code Entity}
     * @return набор объектов типа {@code DTO}
     */
    Set<DishIngredientDTO> toDTOSet(Set<DishIngredientEntity> entitySet);
}
