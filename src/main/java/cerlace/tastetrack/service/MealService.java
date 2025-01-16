package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.MealDTO;

import java.util.List;

public interface MealService extends CrudService<MealDTO> {
    /**
     * Получает все {@code MealDTO}, которые относятся к пользователю
     * @param userId идентификатор пользователя
     * @return список приемов пищи в формате {@code List<MealDTO>}
     */
    List<MealDTO> getAllMealsOfUser(Long userId);
}
