package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.DietDiaryDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.entity.MealEntity;

import java.time.LocalDate;

public interface MealService {
    /**
     * Конвертирует {@link MealDTO} в {@link MealEntity}
     * и передает на слой Repository для сохранения или обновления.
     *
     * @param dto {@link MealDTO}, который нужно записать в БД
     * @return записанный в БД {@link MealDTO} с id
     */
    MealDTO save(MealDTO dto);

    /**
     * Получает из слоя Repository объект {@link MealEntity} по id и
     * конвертирует его в объект {@link MealDTO}.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    MealDTO get(Long id);

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     *           или не произошло удаление
     */
    void delete(Long id);

    /**
     * Получает объект дневника питания, который содержит приемы пищи
     * в определенном промежутки и данные о калорийности.
     *
     * @param username имя пользователя.
     * @param date     дата из промежутка
     * @return дневник питания пользователя.
     */
    DietDiaryDTO getDietDiary(String username, LocalDate date);

    /**
     * Получает объект дневника питания, который содержит приемы пищи
     * в определенном промежутки и данные о калорийности.
     *
     * @param userId идентификатор пользователя.
     * @param date   дата из промежутка
     * @return дневник питания пользователя.
     */
    DietDiaryDTO getDietDiary(Long userId, LocalDate date);
}
