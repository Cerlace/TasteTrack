package cerlace.tastetrack.core.mapper;

import cerlace.tastetrack.core.dto.MealDTO;
import cerlace.tastetrack.persistence.entity.MealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, DishMapper.class})
public interface MealMapper {
    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

    /**
     * Метод конвертирует {@code Entity} в {@code DTO}
     *
     * @param entity входной объект типа {@code Entity}
     * @return объект типа {@code DTO}
     */
    MealDTO toDTO(MealEntity entity);

    /**
     * Метод конвертирует {@code DTO} в {@code Entity}
     *
     * @param dto входной объект типа {@code DTO}
     * @return объект типа {@code Entity}
     */
    MealEntity toEntity(MealDTO dto);

    /**
     * Метод конвертирует список объектов {@code Entity} в
     * список объектов {@code DTO}
     *
     * @param entityList входной список объектов типа {@code Entity}
     * @return список объектов типа {@code DTO}
     */
    List<MealDTO> toDTOList(List<MealEntity> entityList);
}
