package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.UserDAO;
import cerlace.tastetrack.entity.UserEntity;
import org.slf4j.LoggerFactory;

public class UserDAOImpl extends AbstractDAO<UserEntity> implements UserDAO {

    public UserDAOImpl() {
        super(UserEntity.class, LoggerFactory.getLogger(UserDAOImpl.class));
    }
}
