package cerlace.tastetrack.enums;

public enum ConstraintType {
    UNIQUE,
    FOREIGN_KEY_CHILD,
    FOREIGN_KEY_PARENT,
    UNKNOWN
}
// Вопрос: можно ли тут перечислить все типы Constraint базы данных, чтобы обрабатывать каждое по своему