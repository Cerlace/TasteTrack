package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    /**
     * Метод находит ингредиент по имени.
     *
     * @param name имя ингредиента
     * @return найденный ингредиент.
     */
    IngredientEntity findByName(String name);
}