package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends IMapper<UserDTO, UserEntity> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
