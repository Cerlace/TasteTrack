package cerlace.tastetrack.utils;

import cerlace.tastetrack.utils.interfaces.HibernateExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class ExecutorUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorUtil.class);
    /**
     * Метод для сокращения повторяющегося кода.
     * Начинает транзакцию и делает коммит, если операция с БД прошла успешно.
     * Откатывает изменения, если во время выполнения транзакции произошла ошибка.
     * @param entityManager сессия для работы с БД
     * @param hibernateExecutor функциональный интерфейс,
     * который выполняет операции с БД
     * @return результат выполнения метода интерфейса HibernateExecutor
     * @param <T> тип объекта, с таблицей которого проводятся операции в БД
     */
    public static <T> T executeHibernate(EntityManager entityManager,
                                         HibernateExecutor<T> hibernateExecutor) {
        try {
            entityManager.getTransaction().begin();
            T t = hibernateExecutor.execute(entityManager);
            entityManager.getTransaction().commit();
            LOGGER.info("Transaction completed successfully");

            return t;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            LOGGER.error("Error executing transaction", e);
            return null;
        }
    }
}
