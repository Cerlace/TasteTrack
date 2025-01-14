package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DishDAO;
import cerlace.tastetrack.entity.DishEntity;
import org.slf4j.LoggerFactory;

public class DishDAOImpl extends AbstractDAO<DishEntity> implements DishDAO {

    public DishDAOImpl() {
        super(DishEntity.class, LoggerFactory.getLogger(DishDAOImpl.class));
    }
}
