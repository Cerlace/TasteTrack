package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.UserDetailsDAO;
import cerlace.tastetrack.entity.UserDetailsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDetailsDAOImpl extends AbstractDAO<UserDetailsEntity> implements UserDetailsDAO {
    private static final Class<UserDetailsEntity> CLAZZ = UserDetailsEntity.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsDAOImpl.class);

    public UserDetailsDAOImpl() {
        super(CLAZZ, LOGGER);
    }
}
