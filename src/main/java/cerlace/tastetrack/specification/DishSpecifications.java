package cerlace.tastetrack.specification;

import cerlace.tastetrack.entity.DishEntity;
import cerlace.tastetrack.entity.DishEntity_;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.entity.DishIngredientEntity_;
import cerlace.tastetrack.entity.IngredientEntity_;
import cerlace.tastetrack.enums.DishType;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
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
                (name == null)
                        ? cb.conjunction()
                        : cb.like(cb.lower(root.get(DishEntity_.NAME)), "%" + name.toLowerCase() + "%");
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
                (types == null || types.isEmpty())
                        ? cb.conjunction()
                        : root.get(DishEntity_.DISH_TYPE).in(types);
    }

    /**
     * Создает спецификацию для фильтрации блюд по ингредиентам.
     * Если {@code ingredientIds} равен {@code null} или пуст, условие игнорируется.
     *
     * @param ingredientIds список идентификаторов ингредиентов для фильтрации (может быть {@code null}).
     * @return спецификация для написания запроса фильтрации.
     */
    public static Specification<DishEntity> hasIngredientIn(@Nullable List<Long> ingredientIds) {
        return (root, query, cb) -> {
            if (ingredientIds == null || ingredientIds.isEmpty()) {
                return cb.conjunction();
            }

            Subquery<Long> subquery = query.subquery(Long.class);
            Root<DishIngredientEntity> diRoot = subquery.from(DishIngredientEntity.class);

            subquery.select(diRoot.get(DishIngredientEntity_.DISH).get(DishEntity_.ID))
                    .where(diRoot.get(DishIngredientEntity_.INGREDIENT)
                            .get(IngredientEntity_.ID).in(ingredientIds))
                    .groupBy(diRoot.get(DishIngredientEntity_.DISH))
                    .having(cb.equal(cb.countDistinct(
                                    diRoot.get(DishIngredientEntity_.INGREDIENT).get(IngredientEntity_.ID)),
                            ingredientIds.size()));

            return root.get(DishEntity_.ID).in(subquery);
        };
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
                (min == null)
                        ? cb.conjunction()
                        : cb.greaterThanOrEqualTo(root.get(DishEntity_.CALORIES), min);
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
                (max == null)
                        ? cb.conjunction()
                        : cb.lessThanOrEqualTo(root.get(DishEntity_.CALORIES), max);
    }
}
