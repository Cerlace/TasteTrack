package cerlace.tastetrack.utils.interfaces;

/**
 * Интерфейс для обозначения классов, которые содержат идентификатор
 * типа {@code Long}.
 */
public interface Identifiable {
    /**
     * Метод геттер для идентификатора типа {@code Long}
     *
     * @return идентификатора типа {@code Long}
     */
    Long getId();

    /**
     * Метод сеттер для идентификатора типа {@code Long}
     *
     * @param id идентификатора типа {@code Long}
     */
    void setId(Long id);
}
