package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper extends IMapper<DishDTO, DishEntity> {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);

    @Mapping(target = "dishIngredients", ignore = true)
    DishDTO toDTO(DishEntity entity);

    @Mapping(target = "dishIngredients", ignore = true)
    DishEntity toEntity(DishDTO dto);
}
