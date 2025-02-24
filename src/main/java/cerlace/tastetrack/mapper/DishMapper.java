package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper extends IMapper<DishDTO, DishEntity> {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);
}
