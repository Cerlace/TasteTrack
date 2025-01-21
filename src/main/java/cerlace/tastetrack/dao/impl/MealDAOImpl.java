package cerlace.tastetrack.dao.impl;

import cerlace.tastetrack.dao.MealDAO;
import cerlace.tastetrack.entity.MealEntity;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MealDAOImpl extends AbstractDAO<MealEntity> implements MealDAO {
    private static final String GET_ALL_BY_USER_LOG_MESSAGE = "Start getting all rows where user_id = {}";

    private static final String GET_ALL_BY_USER_QUERY =
            "FROM MealEntity meal WHERE meal.user.id = :userId ";
    private static final String USER_ID_PARAM = "userId";

    public MealDAOImpl() {
        super(MealEntity.class, LoggerFactory.getLogger(MealDAOImpl.class));
    }

    @Override
    public List<MealEntity> getAllMealsOfUser(Long userId) {
        getLogger().info(GET_ALL_BY_USER_LOG_MESSAGE, userId);
        return super.getEntityManager().createQuery(GET_ALL_BY_USER_QUERY, getClazz())
                .setParameter(USER_ID_PARAM, userId)
                .getResultList();
    }
}
