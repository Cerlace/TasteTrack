package cerlace.tastetrack.web.service;

import cerlace.tastetrack.core.dto.DishDTO;
import cerlace.tastetrack.core.dto.DishFilter;
import cerlace.tastetrack.core.dto.DishIngredientDTO;
import cerlace.tastetrack.core.dto.IngredientDTO;
import cerlace.tastetrack.core.dto.PageSettings;
import cerlace.tastetrack.persistence.entity.DishEntity;
import cerlace.tastetrack.persistence.entity.DishEntity_;
import cerlace.tastetrack.persistence.entity.DishIngredientEntity;
import cerlace.tastetrack.persistence.entity.IngredientEntity;
import cerlace.tastetrack.persistence.entity.IngredientEntity_;
import cerlace.tastetrack.persistence.enums.DishType;
import cerlace.tastetrack.persistence.enums.MeasureUnit;
import cerlace.tastetrack.persistence.enums.ProductType;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestConstants {
    public static final int PAGE_NUMBER = 0;
    public static final int PAGE_SIZE = 2;

    public static final String INGREDIENT_1_NAME = "Flour";
    public static final String INGREDIENT_2_NAME = "Sugar";
    public static final String INGREDIENT_3_NAME = "Butter";
    public static final String NEW_INGREDIENT_NAME = "Salt";
    public static final ProductType PRODUCT_TYPE = ProductType.OTHER;

    public static final int INGREDIENT_COUNT_IN_DISH = 2;

    public static final String DISH_1_NAME = "Apple Pie";
    public static final String DISH_2_NAME = "Cheesecake";
    public static final String DISH_3_NAME = "Fried egg";
    public static final String NEW_DISH_NAME = "New Dish";
    public static final DishType DISH_TYPE = DishType.DESSERT;
    public static final float CALORIES = 500f;
    public static final float AMOUNT = 100f;
    public static final int EXPECTED_FILTERED_COUNT = 1;

    public static List<IngredientEntity> testIngredients() {
        return List.of(
                ingredient(INGREDIENT_1_NAME),
                ingredient(INGREDIENT_2_NAME),
                ingredient(INGREDIENT_3_NAME)
        );
    }

    public static List<DishEntity> testDishes() {
        List<IngredientEntity> ingredients = testIngredients();
        return List.of(
                dish(DISH_1_NAME, DishType.DESSERT, 450, ingredients.subList(0, 2)),
                dish(DISH_2_NAME, DishType.DESSERT, 600, ingredients.subList(1, 3)),
                dish(DISH_3_NAME, DishType.BREAKFAST, 300, ingredients.subList(0, 1))
        );
    }

    public static IngredientEntity ingredient(String name) {
        return IngredientEntity.builder()
                .name(name)
                .productType(PRODUCT_TYPE)
                .build();
    }

    public static DishEntity dish(String name, DishType type, float calories, List<IngredientEntity> ingredients) {
        DishEntity dish = DishEntity.builder()
                .name(name)
                .dishType(type)
                .calories(calories)
                .proteins(0f)
                .fats(0f)
                .carbohydrates(0f)
                .recipe("")
                .build();

        Set<DishIngredientEntity> dishIngredientEntities = ingredients.stream()
                .map(ingredientEntity -> DishIngredientEntity.builder()
                        .ingredient(ingredientEntity)
                        .dish(dish)
                        .amount(AMOUNT)
                        .measureUnit(MeasureUnit.GRAM)
                        .build())
                .collect(Collectors.toSet());

        dish.setDishIngredients(dishIngredientEntities);

        return dish;
    }

    public static IngredientDTO newIngredientDTO() {
        return IngredientDTO.builder()
                .name(NEW_INGREDIENT_NAME)
                .productType(ProductType.OTHER)
                .build();
    }

    public static DishDTO newDishDTO() {
        return DishDTO.builder()
                .name(NEW_DISH_NAME)
                .dishType(DishType.MAIN)
                .calories(CALORIES)
                .proteins(0f)
                .fats(0f)
                .carbohydrates(0f)
                .recipe("")
                .build();
    }

    public static DishIngredientDTO newDishIngredientDTO(Long dishId, Long ingredientId) {
        return DishIngredientDTO.builder()
                .dish(DishDTO.builder().id(dishId).build())
                .ingredient(IngredientDTO.builder().id(ingredientId).build())
                .amount(AMOUNT)
                .measureUnit(MeasureUnit.GRAM)
                .build();
    }

    public static PageSettings ingredientsFirstPage() {
        return PageSettings.builder()
                .page(PAGE_NUMBER)
                .size(PAGE_SIZE)
                .sortDirection(Sort.Direction.ASC.name())
                .sortField(IngredientEntity_.NAME)
                .build();
    }

    public static PageSettings dishesFirstPage() {
        return PageSettings.builder()
                .page(PAGE_NUMBER)
                .size(PAGE_SIZE)
                .sortDirection(Sort.Direction.ASC.name())
                .sortField(DishEntity_.NAME)
                .build();
    }

    public static DishFilter dishFilter() {
        return DishFilter.builder()
                .name("pie")
                .dishTypes(List.of(DISH_TYPE))
                .minCalories(400)
                .maxCalories(700)
                .build();
    }

    public static DishEntity testDish() {
        return DishEntity.builder()
                .name(DISH_1_NAME)
                .dishType(DISH_TYPE)
                .calories(0f)
                .proteins(0f)
                .fats(0f)
                .carbohydrates(0f)
                .recipe("")
                .build();
    }

    public static IngredientEntity testIngredient() {
        return IngredientEntity.builder()
                .name(INGREDIENT_1_NAME)
                .productType(PRODUCT_TYPE)
                .build();
    }


}
