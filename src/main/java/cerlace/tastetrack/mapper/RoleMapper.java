package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.RoleDTO;
import cerlace.tastetrack.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface RoleMapper extends IMapper<RoleDTO, RoleEntity> {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}


