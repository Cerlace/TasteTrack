package cerlace.tastetrack.dao;

import cerlace.tastetrack.entity.MealEntity;

import java.util.List;

public interface MealDAO extends DAO<MealEntity> {
    /**
     * Получает все {@code MealEntity}, которые относятся к пользователю
     * @param userId идентификатор пользователя
     * @return список приемов пищи в формате {@code List<MealEntity>}
     */
    List<MealEntity> getAllMealsOfUser(Long userId);
}
