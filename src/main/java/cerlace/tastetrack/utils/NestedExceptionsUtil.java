package cerlace.tastetrack.utils;

public class NestedExceptionsUtil {
    /**
     * Метод для получения необходимого типа исключения
     * из причин входного исключения
     *
     * @param clazz        объект класса необходимого исключения
     * @param throwable    исключение, из которого необходимо получить причину
     * @param <ExceptionT> тип необходимого исключения
     * @return исключение необходимого типа в случае если оно есть среди причин,
     * {@code null} - в случае его отсутствия.
     */
    public static <ExceptionT extends Throwable> ExceptionT getExceptionFromCauses(
            Throwable throwable, Class<ExceptionT> clazz) {
        Throwable cause;
        while ((cause = throwable.getCause()) != null) {
            throwable = cause;
            if (clazz.isInstance(cause)) {
                return clazz.cast(cause);
            }
        }
        return null;
    }
}
