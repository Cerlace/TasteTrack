package cerlace.tastetrack.persistence.repository;

import cerlace.tastetrack.persistence.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {

    /**
     * Получает все {@code MealEntity}, которые относятся к пользователю.
     * Дата приемов пищи указывается промежутком.
     *
     * @param username имя пользователя.
     * @param start    начало промежутка
     * @param end      конец промежутка
     * @return список приемов пищи соответствующих условию в формате {@code List<MealEntity>}
     */
    List<MealEntity> findByUserUsernameAndDateBetween(String username, LocalDate start, LocalDate end);
}