package cerlace.tastetrack.utils;


import cerlace.tastetrack.enums.ConstraintType;
import cerlace.tastetrack.exceptions.ConstraintViolationAppException;
import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.function.Supplier;

public class ServiceUtil {

    public static final int MY_SQL_UK_ERROR = 1062;
    public static final int MY_SQL_FK_PARENT_ERROR = 1451;
    public static final int MY_SQL_FK_CHILD_ERROR = 1452;

    /**
     * Метод для обработки ошибок Hibernate, и преобразования их в бизнес ошибки.
     *
     * @param serviceExecutor функциональный интерфейс типа {@code Supplier<T>},
     *                        который выполняет метод сервиса и возвращает результат
     * @param <T>             тип возвращаемого значения
     * @return результат выполнения метода интерфейса ServiceExecutor
     */
    public static <T> T handleServiceExceptions(Supplier<T> serviceExecutor) {
        try {
            return serviceExecutor.get();
        } catch (ConstraintViolationException e) {
            SQLIntegrityConstraintViolationException exception =
                    NestedExceptionsUtil.getExceptionFromCauses(e, SQLIntegrityConstraintViolationException.class);
            if (exception != null && exception.getSQLState().startsWith("23")) {
                switch (exception.getErrorCode()) {
                    case MY_SQL_UK_ERROR:
                        throw new ConstraintViolationAppException(
                                exception.getMessage(), ConstraintType.UNIQUE);
                    case MY_SQL_FK_PARENT_ERROR:
                        throw new ConstraintViolationAppException(
                                exception.getMessage(), ConstraintType.FOREIGN_KEY_PARENT);
                    case MY_SQL_FK_CHILD_ERROR:
                        throw new ConstraintViolationAppException(
                                exception.getMessage(), ConstraintType.FOREIGN_KEY_CHILD);
                    default:
                        throw new ConstraintViolationAppException(
                                exception.getMessage(), ConstraintType.UNKNOWN);
                }
            }
            return null;
        }
    }
}
