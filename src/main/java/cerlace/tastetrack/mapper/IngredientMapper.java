package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.entity.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper extends IMapper<IngredientDTO, IngredientEntity> {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);
}
