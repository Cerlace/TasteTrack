package cerlace.tastetrack.mapper;

import cerlace.tastetrack.dto.UserDetailsDTO;
import cerlace.tastetrack.entity.UserDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailsMapper extends IMapper<UserDetailsDTO, UserDetailsEntity> {
    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);
}
