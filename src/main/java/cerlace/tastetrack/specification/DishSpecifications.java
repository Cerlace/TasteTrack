package cerlace.tastetrack.specification;

import cerlace.tastetrack.entity.DishEntity;
import cerlace.tastetrack.entity.DishEntity_;
import cerlace.tastetrack.enums.DishType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.util.List;

public class DishSpecifications {
    /**
     * Создает спецификацию для фильтрации блюд по названию (без учета регистра, частичное совпадение).
     * Если параметр {@code name} равен {@code null}, условие игнорируется.
     *
     * @param name текст для поиска в названии блюда (может быть {@code null}).
     * @return спецификация, добавляющая условие {@code WHERE name LIKE '%name%'} (в нижнем регистре).
     */
    public static Specification<DishEntity> hasNameLike(@Nullable String name) {
        return (root, query, cb) ->
                name != null
                        ? cb.like(cb.lower(root.get(DishEntity_.NAME)), "%" + name.toLowerCase() + "%")
                        : cb.conjunction();
    }
    /**
     * Создает спецификацию для фильтрации блюд по типам.
     * Если {@code types} равен {@code null} или пуст, условие игнорируется.
     *
     * @param types список типов блюд для фильтрации (может быть {@code null}).
     * @return спецификация, добавляющая условие {@code WHERE dishType IN (types)}.
     */
    public static Specification<DishEntity> hasTypeIn(@Nullable List<DishType> types) {
        return (root, query, cb) ->
                types != null && !types.isEmpty()
                        ? root.get(DishEntity_.DISH_TYPE).in(types)
                        : cb.conjunction();
    }
    /**
     * Создает спецификацию для фильтрации блюд с калорийностью не менее указанного значения.
     * Если {@code min} равен {@code null}, условие игнорируется.
     *
     * @param min минимальное количество калорий (может быть {@code null}).
     * @return спецификация, добавляющая условие {@code WHERE calories >= min}.
     */
    public static Specification<DishEntity> hasMinCalories(@Nullable Integer min) {
        return (root, query, cb) ->
                (min != null)
                        ? cb.greaterThanOrEqualTo(root.get(DishEntity_.CALORIES), min)
                        : cb.conjunction();
    }
    /**
     * Создает спецификацию для фильтрации блюд с калорийностью не более указанного значения.
     * Если {@code max} равен {@code null}, условие игнорируется.
     *
     * @param max максимальное количество калорий (может быть {@code null}).
     * @return спецификация, добавляющая условие {@code WHERE calories <= max}.
     */
    public static Specification<DishEntity> hasMaxCalories(@Nullable Integer max) {
        return (root, query, cb) ->
                (max != null)
                        ? cb.lessThanOrEqualTo(root.get(DishEntity_.CALORIES), max)
                        : cb.conjunction();
    }
}
