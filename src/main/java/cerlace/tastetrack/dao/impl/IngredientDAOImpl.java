package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.IngredientDAO;
import cerlace.tastetrack.entity.IngredientEntity;
import org.slf4j.LoggerFactory;

public class IngredientDAOImpl extends AbstractDAO<IngredientEntity> implements IngredientDAO {

    public IngredientDAOImpl() {
        super(IngredientEntity.class, LoggerFactory.getLogger(IngredientDAOImpl.class));
    }
}
