package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.DAO;
import cerlace.tastetrack.utils.interfaces.Identifiable;
import cerlace.tastetrack.utils.HibernateUtil;
import lombok.AccessLevel;
import lombok.Getter;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;

@Getter(AccessLevel.PROTECTED)
public abstract class AbstractDAO<EntityT extends Identifiable> implements DAO<EntityT> {
    protected static final String SAVE_LOG_MESSAGE = "Start saving object {}";
    protected static final String GET_LOG_MESSAGE = "Start getting row with id = {}";
    protected static final String UPDATE_LOG_MESSAGE = "Start updating row with id = {}";
    protected static final String DELETE_LOG_MESSAGE = "Start deleting row with id = {}";
    protected static final String GET_ALL_LOG_MESSAGE = "Start getting all rows";
    protected static final String CLOSING_ENTITY_MANAGER = "Closing entity manager";

    private final Class<EntityT> clazz;
    private final Logger logger;
    private final EntityManager entityManager;

    public AbstractDAO(Class<EntityT> clazz, Logger logger) {
        this.clazz = clazz;
        this.logger = logger;
        this.entityManager = HibernateUtil.getEntityManager();
    }

    @Override
    public EntityT save(EntityT entity) {
        logger.info(SAVE_LOG_MESSAGE, entity);
        return HibernateUtil.executeHibernateTransaction(entityManager, () -> {
            entityManager.persist(entity);
            entityManager.refresh(entity);
            return entity;
        });
    }

    @Override
    public EntityT get(Long id) {
        logger.info(GET_LOG_MESSAGE, id);
        return entityManager.find(clazz, id);
    }

    @Override
    public List<EntityT> getAll() {
        logger.info(GET_ALL_LOG_MESSAGE);
        String query = "FROM " + clazz.getSimpleName();
        return entityManager.createQuery(query, clazz).getResultList();
    }

    @Override
    public EntityT update(Long id, EntityT entity) {
        logger.info(UPDATE_LOG_MESSAGE, id);
        entity.setId(id);
        return HibernateUtil.executeHibernateTransaction(entityManager, () -> {
            EntityT updatedEntity = entityManager.find(clazz, id);
            if (updatedEntity != null) {
                updatedEntity = entityManager.merge(entity);
            }
            return updatedEntity;
        });
    }

    @Override
    public boolean delete(Long id) {
        logger.info(DELETE_LOG_MESSAGE, id);
        return Boolean.TRUE.equals(HibernateUtil.executeHibernateTransaction(entityManager, () -> {
            EntityT entity = entityManager.find(clazz, id);
            if (entity != null) {
                entityManager.remove(entity);
                return true;
            } else {
                return false;
            }
        }));
    }

    @Override
    public void close() {
        if (entityManager.isOpen()) {
            logger.info(CLOSING_ENTITY_MANAGER);
            entityManager.close();
        }
    }
}
