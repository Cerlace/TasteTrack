package cerlace.tastetrack.utils;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.requestmapper.RequestMapper;
import cerlace.tastetrack.requestmapper.impl.DishIngredientRequestMapper;
import cerlace.tastetrack.requestmapper.impl.DishRequestMapper;
import cerlace.tastetrack.requestmapper.impl.IngredientRequestMapper;
import cerlace.tastetrack.requestmapper.impl.MealRequestMapper;
import cerlace.tastetrack.requestmapper.impl.UserRequestMapper;

import java.util.HashMap;
import java.util.Map;

public class RequestMapperFactory {
    private static final Map<Class, RequestMapper> REQUEST_MAPPER_MAP = new HashMap<>();

    static {
        REQUEST_MAPPER_MAP.put(DishIngredientDTO.class, new DishIngredientRequestMapper());
        REQUEST_MAPPER_MAP.put(DishDTO.class, new DishRequestMapper());
        REQUEST_MAPPER_MAP.put(IngredientDTO.class, new IngredientRequestMapper());
        REQUEST_MAPPER_MAP.put(MealDTO.class, new MealRequestMapper());
        REQUEST_MAPPER_MAP.put(UserDTO.class, new UserRequestMapper());
    }

    /**
     * Получает объект типа {@code RequestMapper} для преобразования
     * параметров запроса в необходимый DTO
     *
     * @param clazz класс типа необходимого DTO
     * @param <T>   тип необходимого DTO
     * @return {@code RequestMapper} возвращающий DTO
     */
    public static <T> RequestMapper<T> getMapper(Class<T> clazz) {
        return REQUEST_MAPPER_MAP.get(clazz);
    }
}
