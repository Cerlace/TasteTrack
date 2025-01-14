package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DishIngredientDAO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.utils.ExecutorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DishIngredientDAOImpl extends AbstractDAO<DishIngredientEntity> implements DishIngredientDAO {
    private static final String GET_ALL_BY_DISH_LOG_MESSAGE = "Start getting all rows where dish_id = {}";

    private static final Class<DishIngredientEntity> CLAZZ = DishIngredientEntity.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(DishIngredientDAOImpl.class);

    private static final String GET_ALL_BY_DISH_QUERY =
            "FROM DishIngredientEntity dishIngridient WHERE dishIngridient.dish.id = :dishId ";

    public DishIngredientDAOImpl() {
        super(CLAZZ, LOGGER);
    }

    @Override
    public DishIngredientEntity save(DishIngredientEntity entity) {
        LOGGER.info(SAVE_LOG_MESSAGE, entity);
        return ExecutorUtil.executeHibernate(super.getEntityManager(), em -> {
            em.merge(entity);
            return entity;
        });
    }

    @Override
    public List<DishIngredientEntity> getAllIngredientOfDish(Long dishId) {
        LOGGER.info(GET_ALL_BY_DISH_LOG_MESSAGE, dishId);
        return super.getEntityManager().createQuery(GET_ALL_BY_DISH_QUERY, CLAZZ)
        .setParameter("dishId", dishId)
        .getResultList();
    }
}