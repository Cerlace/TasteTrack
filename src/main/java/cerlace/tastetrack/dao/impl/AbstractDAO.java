package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DAO;
import cerlace.tastetrack.utils.ExecutorUtil;
import cerlace.tastetrack.utils.HibernateUtil;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T> {
    private static final String SAVE_LOG_MESSAGE = "Start saving object {}";
    private static final String GET_LOG_MESSAGE = "Start getting row with id = {}";
    private static final String UPDATE_LOG_MESSAGE = "Start updating row with id = {}";
    private static final String DELETE_LOG_MESSAGE = "Start deleting row with id = {}";
    private static final String GET_ALL_LOG_MESSAGE = "Start getting all rows";
    private static final String CLOSING_ENTITY_MANAGER = "Closing entity manager";

    private final Class<T> clazz;
    private final Logger logger;
    private final EntityManager entityManager;

    public AbstractDAO(Class<T> clazz, Logger logger) {
        this.clazz = clazz;
        this.logger = logger;
        this.entityManager = HibernateUtil.getEntityManager();
    }

    @Override
    public T save(T entity) {
        logger.info(SAVE_LOG_MESSAGE, entity);
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            em.persist(entity);
            return entity;
        });
    }

    @Override
    public T get(Long id) {
        logger.info(GET_LOG_MESSAGE, id);
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> getAll() {
        logger.info(GET_ALL_LOG_MESSAGE);
        String query = "FROM " + clazz.getSimpleName();
        return entityManager.createQuery(query, clazz).getResultList();
    }

    @Override
    public T update(Long id, T entity) {
        logger.info(UPDATE_LOG_MESSAGE, id);
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            T updatedEntity = this.entityManager.find(clazz, id);
            if (updatedEntity != null) {
                updatedEntity = em.merge(entity);
            }
            return updatedEntity;
        });
    }

    @Override
    public boolean delete(Long id) {
        logger.info(DELETE_LOG_MESSAGE, id);
        return Boolean.TRUE.equals(ExecutorUtil.executeHibernate(this.entityManager, em -> {
            T entity = em.find(clazz, id);
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
