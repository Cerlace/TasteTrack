package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DishIngredientDAO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.utils.ExecutorUtil;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DishIngredientDAOImpl extends AbstractDAO<DishIngredientEntity> implements DishIngredientDAO {
    private static final String GET_ALL_BY_DISH_LOG_MESSAGE = "Start getting all rows where dish_id = {}";

    private static final String GET_ALL_BY_DISH_QUERY =
            "FROM DishIngredientEntity dishIngridient WHERE dishIngridient.dish.id = :dishId ";
    private static final String DISH_ID_PARAM = "dishId";

    public DishIngredientDAOImpl() {
        super(DishIngredientEntity.class, LoggerFactory.getLogger(DishIngredientDAOImpl.class));
    }

    @Override
    public DishIngredientEntity save(DishIngredientEntity entity) {
        getLogger().info(SAVE_LOG_MESSAGE, entity);
        return ExecutorUtil.executeHibernate(super.getEntityManager(), em -> {
            em.merge(entity);
            return entity;
        });
    }

    @Override
    public List<DishIngredientEntity> getAllIngredientOfDish(Long dishId) {
        getLogger().info(GET_ALL_BY_DISH_LOG_MESSAGE, dishId);
        return super.getEntityManager().createQuery(GET_ALL_BY_DISH_QUERY, getClazz())
                .setParameter(DISH_ID_PARAM, dishId)
                .getResultList();
    }
}