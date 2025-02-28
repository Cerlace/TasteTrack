package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {
    /**
     * Получает все {@code MealEntity}, которые относятся к пользователю
     * @param userId идентификатор пользователя
     * @return список приемов пищи в формате {@code List<MealEntity>}
     */
    List<MealEntity> getAllByUserId(Long userId);
}