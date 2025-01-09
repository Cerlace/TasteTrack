package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.MealDAO;
import cerlace.tastetrack.entity.MealEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MealDAOImpl extends AbstractDAO<MealEntity> implements MealDAO {
    private static final Class<MealEntity> CLAZZ = MealEntity.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(MealDAOImpl.class);

    public MealDAOImpl() {
        super(CLAZZ, LOGGER);
    }
}
