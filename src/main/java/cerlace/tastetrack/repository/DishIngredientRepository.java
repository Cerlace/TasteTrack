package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.DishIngredientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishIngredientRepository extends JpaRepository<DishIngredientEntity, Long> {
    /**
     * Получает все {@code DishIngredientEntity}, которые относятся к блюду
     *
     * @param dishId идентификатор блюда
     * @return список ингредиентов в формате {@code List<DishIngredientEntity>}
     */
    List<DishIngredientEntity> findByDishId(Long dishId);
}