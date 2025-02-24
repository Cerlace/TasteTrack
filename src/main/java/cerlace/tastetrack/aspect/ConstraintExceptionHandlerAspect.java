package cerlace.tastetrack.aspect;

import cerlace.tastetrack.enums.ConstraintType;
import cerlace.tastetrack.exceptions.ConstraintViolationAppException;
import cerlace.tastetrack.utils.NestedExceptionsUtil;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;

@Aspect
@Component
public class ConstraintExceptionHandlerAspect {
    public static final int MY_SQL_UK_ERROR = 1062;
    public static final int MY_SQL_FK_PARENT_ERROR = 1451;
    public static final int MY_SQL_FK_CHILD_ERROR = 1452;

    @AfterThrowing(pointcut = "execution(* cerlace.tastetrack.service..*(..))", throwing = "ex")
    public void handleServiceExceptions(Throwable ex) {
        SQLIntegrityConstraintViolationException exception =
                NestedExceptionsUtil.getExceptionFromCauses(ex, SQLIntegrityConstraintViolationException.class);
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
    }
}
