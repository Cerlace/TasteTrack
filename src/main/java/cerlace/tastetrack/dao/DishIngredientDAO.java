package cerlace.tastetrack.dao;

import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.entity.DishIngredientPK;

import java.util.List;

public interface DishIngredientDAO {
    /**
     * Метод сохраняет новую строку таблицы в БД. Строка может содержать различные параметры.
     * @param entity строка таблицы, представленная объектом класса Entity {@code <DishIngredientEntity>}.
     * @return сохраненный объект.
     */
    DishIngredientEntity save(DishIngredientEntity entity);
    /**
     * Метод возвращает параметры строки таблицы по идентификатору строки {@code id}.
     * @param id идентификатор строки таблицы БД
     * @return полученный из БД объект по-заданному id или null, если объект не найден
     */
    DishIngredientEntity get(DishIngredientPK id);
    /**
     * Метод возвращает список всех строк таблицы в том порядке, в котором они представлены в таблице БД
     * @return список всех объектов, хранящихся в таблице
     */
    List<DishIngredientEntity> getAll();

    /**
     * Метод удаляет строку таблицы БД по идентификатору строки {@code id}.
     * @param id идентификатор строки таблицы БД
     * @return true - если запись удалена успешно, false - если запись с таким id не была найдена
     */
    boolean delete(DishIngredientPK id);

    /**
     * Метод для закрытия EntityManager
     */
    void close();
}
