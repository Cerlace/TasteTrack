package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.UserDAO;
import cerlace.tastetrack.dao.impl.UserDAOImpl;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.entity.UserDetailsEntity;
import cerlace.tastetrack.entity.UserEntity;
import cerlace.tastetrack.mapper.UserMapper;
import cerlace.tastetrack.service.UserService;

public class UserServiceImpl extends AbstractService<UserDTO, UserEntity> implements UserService {
    private final UserDAO userDAO;
    private final UserMapper userMapper;

    public UserServiceImpl() {
        super(new UserDAOImpl(), UserMapper.INSTANCE);
        this.userDAO = (UserDAO) super.getDao();
        this.userMapper = (UserMapper) getMapper();
    }
    @Override
    public UserDTO save(UserDTO dto) {
        UserEntity entity = userMapper.toEntity(dto);
        entity.setUserDetails(new UserDetailsEntity());
        return userMapper.toDTO(userDAO.save(entity));
    }
}
