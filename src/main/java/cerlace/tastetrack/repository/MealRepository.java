package cerlace.tastetrack.repository;

import cerlace.tastetrack.entity.MealEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {
    /**
     * Получает все {@code MealEntity}, которые относятся к пользователю
     *
     * @param userId идентификатор пользователя.
     * @return список приемов пищи в формате {@code List<MealEntity>}
     */
    List<MealEntity> findByUserId(Long userId);

    /**
     * Получает страницу {@code MealEntity}, которые относятся к пользователю
     *
     * @param pageable запрос на получение страницы.
     * @param userId   идентификатор пользователя.
     * @return список приемов пищи в формате {@code List<MealEntity>}
     */
    Page<MealEntity> findByUserId(Pageable pageable, Long userId);

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