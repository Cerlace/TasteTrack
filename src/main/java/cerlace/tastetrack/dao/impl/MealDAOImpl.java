package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.MealDAO;
import cerlace.tastetrack.entity.MealEntity;
import org.slf4j.LoggerFactory;

public class MealDAOImpl extends AbstractDAO<MealEntity> implements MealDAO {

    public MealDAOImpl() {
        super(MealEntity.class, LoggerFactory.getLogger(MealDAOImpl.class));
    }
}
