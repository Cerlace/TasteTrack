package cerlace.tastetrack.web.service.impl;

import cerlace.tastetrack.web.TestConstants;
import cerlace.tastetrack.core.dto.DishDTO;
import cerlace.tastetrack.core.dto.DishFilter;
import cerlace.tastetrack.core.dto.PageSettings;
import cerlace.tastetrack.persistence.repository.DishRepository;
import cerlace.tastetrack.persistence.repository.IngredientRepository;
import cerlace.tastetrack.core.service.DishService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DishService.class,
        DishRepository.class,
        IngredientRepository.class})
@ActiveProfiles("test")
@Transactional
class DishServiceImplTest {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp() {
        ingredientRepository.saveAll(TestConstants.testIngredients());
        dishRepository.saveAll(TestConstants.testDishes());
    }

    @AfterEach
    void tearDown() {
        dishRepository.deleteAll();
        ingredientRepository.deleteAll();
    }

    @Test
    void testSaveOrUpdate_shouldPersistEntity() {
        DishDTO newDto = TestConstants.newDishDTO();

        DishDTO saved = dishService.saveOrUpdate(newDto);

        assertNotNull(saved.getId());
        assertEquals(TestConstants.NEW_DISH_NAME, saved.getName());
        assertTrue(dishRepository.existsById(saved.getId()));
    }

    @Test
    void testGet_shouldReturnExistingEntity() {
        Long targetId = dishRepository.findByName(TestConstants.DISH_1_NAME).getId();

        DishDTO result = dishService.get(targetId);

        assertEquals(targetId, result.getId());
        assertEquals(TestConstants.DISH_1_NAME, result.getName());
    }

    @Test
    void testGetDetailed_shouldReturnWithIngredients() {
        Long targetId = dishRepository.findByName(TestConstants.DISH_1_NAME).getId();

        DishDTO result = dishService.getDetailed(targetId);

        assertFalse(result.getDishIngredients().isEmpty());
        assertEquals(TestConstants.INGREDIENT_COUNT_IN_DISH, result.getDishIngredients().size());
    }

    @Test
    void testGetAll_shouldReturnAllEntities() {
        List<DishDTO> result = dishService.getAll();

        assertEquals(TestConstants.testDishes().size(), result.size());
    }

    @Test
    void testGetFilteredPage_shouldApplyFilters() {
        DishFilter filter = TestConstants.dishFilter();
        PageSettings pageSettings = TestConstants.dishesFirstPage();

        Page<DishDTO> page = dishService.getFilteredPage(pageSettings, filter);

        assertEquals(TestConstants.EXPECTED_FILTERED_COUNT, page.getTotalElements());
        page.getContent().forEach(dishDTO ->
                assertEquals(TestConstants.DISH_TYPE, dishDTO.getDishType()));
    }

    @Test
    void testDelete_shouldRemoveEntity() {
        Long targetId = dishRepository.findByName(TestConstants.DISH_1_NAME).getId();

        assertTrue(dishRepository.existsById(targetId));

        dishService.delete(targetId);

        assertFalse(dishRepository.existsById(targetId));
    }

    @Test
    void testCaloriesRangeFix() {
        DishFilter filter = DishFilter.builder()
                .minCalories(500)
                .maxCalories(400)
                .build();

        dishService.getFilteredPage(TestConstants.dishesFirstPage(), filter);

        assertEquals(400, filter.getMinCalories());
        assertEquals(500, filter.getMaxCalories());
    }

}
