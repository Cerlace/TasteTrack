package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.DishIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishIngredientRepository extends JpaRepository<DishIngredientEntity, Long> {
    List<DishIngredientEntity> getAllByDishId(Long dishId);
}