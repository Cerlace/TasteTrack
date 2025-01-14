package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.DishIngredientDTO;

import java.util.List;

public interface DishIngredientService extends CrudService<DishIngredientDTO> {
    /**
     * Получает все {@code DishIngredientDTO}, которые относятся к блюду
     * @param dishId идентификатор блюда
     * @return список ингредиентов в формате {@code List<DishIngredientDTO>}
     */
    List<DishIngredientDTO> getAllIngredientsOfDish(Long dishId);
}

