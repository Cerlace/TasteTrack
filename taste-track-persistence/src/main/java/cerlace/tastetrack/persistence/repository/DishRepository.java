package cerlace.tastetrack.persistence.repository;

import cerlace.tastetrack.persistence.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long>,
        JpaSpecificationExecutor<DishEntity> {
    /**
     * Метод находит блюдо по имени.
     *
     * @param name имя ингредиента
     * @return найденный ингредиент.
     */
    DishEntity findByName(String name);
}