package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.UserDAO;
import cerlace.tastetrack.dao.impl.UserDAOImpl;
import cerlace.tastetrack.dto.UserDTO;

import cerlace.tastetrack.entity.UserEntity;
import cerlace.tastetrack.mapper.UserMapper;
import cerlace.tastetrack.service.UserService;

public class UserServiceImpl extends AbstractService<UserDTO, UserEntity, UserDAO> implements UserService {

    public UserServiceImpl() {
        super(new UserDAOImpl(), UserMapper.INSTANCE);
    }
}
