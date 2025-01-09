package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DishDAO;
import cerlace.tastetrack.entity.DishEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DishDAOImpl extends AbstractDAO<DishEntity> implements DishDAO {
    private static final Class<DishEntity> CLAZZ = DishEntity.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(DishDAOImpl.class);

    public DishDAOImpl() {
        super(CLAZZ, LOGGER);
    }
}
