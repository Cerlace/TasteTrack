package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.IngredientDAO;
import cerlace.tastetrack.entity.IngredientEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IngredientDAOImpl extends AbstractDAO<IngredientEntity> implements IngredientDAO {
    private static final Class<IngredientEntity> CLAZZ = IngredientEntity.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientDAOImpl.class);

    public IngredientDAOImpl() {
        super(CLAZZ, LOGGER);
    }
}
