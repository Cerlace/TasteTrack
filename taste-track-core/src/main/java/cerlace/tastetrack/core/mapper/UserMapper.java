package cerlace.tastetrack.core.mapper;

import cerlace.tastetrack.core.dto.UserDTO;
import cerlace.tastetrack.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = RoleMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * Метод конвертирует {@code Entity} в {@code DTO}
     *
     * @param entity входной объект типа {@code Entity}
     * @return объект типа {@code DTO}
     */
    @Mapping(target = "password", ignore = true)
    UserDTO toDTO(UserEntity entity);

    /**
     * Метод конвертирует {@code DTO} в {@code Entity}
     *
     * @param dto входной объект типа {@code DTO}
     * @return объект типа {@code Entity}
     */
    UserEntity toEntity(UserDTO dto);

    /**
     * Метод конвертирует список объектов {@code Entity} в
     * список объектов {@code DTO}
     *
     * @param entityList входной список объектов типа {@code Entity}
     * @return список объектов типа {@code DTO}
     */
    List<UserDTO> toDTOList(List<UserEntity> entityList);
}
