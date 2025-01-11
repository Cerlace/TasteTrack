package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DishIngredientDAO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DishIngredientDAOImpl extends AbstractDAO<DishIngredientEntity> implements DishIngredientDAO {
    private static final Class<DishIngredientEntity> CLAZZ = DishIngredientEntity.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(DishIngredientDAOImpl.class);

    public DishIngredientDAOImpl() {
        super(CLAZZ, LOGGER);
    }
}
