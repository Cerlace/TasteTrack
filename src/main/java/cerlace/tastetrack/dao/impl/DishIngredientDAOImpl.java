package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DishIngredientDAO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.entity.DishIngredientPK;
import cerlace.tastetrack.utils.ExecutorUtil;
import cerlace.tastetrack.utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class DishIngredientDAOImpl implements DishIngredientDAO {
    private static final String SAVE_LOG_MESSAGE = "Start saving object {}";
    private static final String GET_LOG_MESSAGE = "Start getting row with id = {}";
    private static final String DELETE_LOG_MESSAGE = "Start deleting row with id = {}";
    private static final String GET_ALL_LOG_MESSAGE = "Start getting all rows";
    private static final String CLOSING_ENTITY_MANAGER = "Closing entity manager";

    private final Class<DishIngredientEntity> clazz = DishIngredientEntity.class;
    private final Logger logger = LoggerFactory.getLogger(DishIngredientDAOImpl.class);
    private final EntityManager entityManager = HibernateUtil.getEntityManager();

    @Override
    public DishIngredientEntity save(DishIngredientEntity entity) {
        logger.info(SAVE_LOG_MESSAGE, entity);
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            em.persist(entity);
            return entity;
        });
    }

    @Override
    public DishIngredientEntity get(DishIngredientPK id) {
        logger.info(GET_LOG_MESSAGE, id);
        return entityManager.find(clazz, id);
    }

    @Override
    public List<DishIngredientEntity> getAll() {
        logger.info(GET_ALL_LOG_MESSAGE);
        String query = "FROM " + clazz.getSimpleName();
        return entityManager.createQuery(query, clazz).getResultList();
    }

    @Override
    public boolean delete(DishIngredientPK id) {
        logger.info(DELETE_LOG_MESSAGE, id);
        return Boolean.TRUE.equals(ExecutorUtil.executeHibernate(this.entityManager, em -> {
            DishIngredientEntity entity = em.find(clazz, id);
            if (entity != null) {
                em.remove(entity);
                return true;
            } else {
                return false;
            }
        }));
    }

    @Override
    public void close() {
        if (this.entityManager.isOpen()) {
            logger.info(CLOSING_ENTITY_MANAGER);
            this.entityManager.close();
        }
    }
}
