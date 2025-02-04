package cerlace.tastetrack.utils;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Supplier;

public class HibernateUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("default");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

    public static final String CREATED_NEW_ENTITY_MANAGER = "Created new Entity Manager.";
    public static final String CLOSING_ENTITY_MANAGER_FACTORY = "Closing Entity Manager Factory.";
    public static final String TRANSACTION_SUCCESS = "Transaction completed successfully";
    public static final String TRANSACTION_ERROR = "Error executing transaction";

    /**
     * Метод создает новый объект EntityManager
     *
     * @return новый EntityManager
     */
    public static EntityManager getNewEntityManager() {
        LOGGER.info(CREATED_NEW_ENTITY_MANAGER);
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    /**
     * Метод возвращает статический объект EntityManager.
     *
     * @return статический объект EntityManager
     */
    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }

    /**
     * Метод закрывает EntityManagerFactory
     */
    public static void close() {
        if (ENTITY_MANAGER_FACTORY.isOpen()) {
            LOGGER.info(CLOSING_ENTITY_MANAGER_FACTORY);
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    /**
     * Метод для запуска методов DAO, требующих транзакцию.
     * Начинает транзакцию и делает коммит, если операция с БД прошла успешно.
     * Откатывает изменения, если во время выполнения транзакции произошла ошибка.
     *
     * @param entityManager     сессия для работы с БД
     * @param hibernateExecutor функциональный интерфейс типа {@code Supplier<T>},
     *                          который выполняет метод DAO и возвращает результат
     * @param <T>               тип возвращаемого значения
     * @return результат выполнения метода интерфейса HibernateExecutor
     */
    public static <T> T executeHibernateTransaction(EntityManager entityManager,
                                                    Supplier<T> hibernateExecutor) {
        try {
            entityManager.getTransaction().begin();
            T t = hibernateExecutor.get();
            entityManager.getTransaction().commit();
            LOGGER.info(TRANSACTION_SUCCESS);

            return t;
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            LOGGER.error(TRANSACTION_ERROR, e);
            ConstraintViolationException constraintViolationException =
                    NestedExceptionsUtil.getExceptionFromCauses(e, ConstraintViolationException.class);
            if (constraintViolationException != null) {
                throw constraintViolationException;
            }
            return null;
        }
    }
}
