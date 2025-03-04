package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper extends IMapper<DishDTO, DishEntity> {
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
}
