package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.entity.MealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MealMapper extends IMapper<MealDTO, MealEntity> {
    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);
}
