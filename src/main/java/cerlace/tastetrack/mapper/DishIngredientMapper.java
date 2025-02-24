package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DishMapper.class, IngredientMapper.class})
public interface DishIngredientMapper extends IMapper<DishIngredientDTO, DishIngredientEntity> {
    DishIngredientMapper INSTANCE = Mappers.getMapper(DishIngredientMapper.class);
}
