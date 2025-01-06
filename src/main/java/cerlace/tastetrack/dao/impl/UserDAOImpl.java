package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.UserDAO;
import cerlace.tastetrack.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOImpl extends AbstractDAO<UserEntity> implements UserDAO {
    private static final Class<UserEntity> CLAZZ = UserEntity.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    public UserDAOImpl() {
        super(CLAZZ, LOGGER);
    }
}
