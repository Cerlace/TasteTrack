package cerlace.tastetrack.dao;

import cerlace.tastetrack.entity.DishIngredientEntity;

import java.util.List;

public interface DishIngredientDAO extends DAO<DishIngredientEntity> {
    /**
     * Получает все {@code DishIngredientEntity}, которые относятся к блюду
     * @param dishId идентификатор блюда
     * @return список ингредиентов в формате {@code List<DishIngredientEntity>}
     */
    List<DishIngredientEntity> getAllIngredientOfDish(Long dishId);
}
