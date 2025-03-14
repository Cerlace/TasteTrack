package cerlace.tastetrack.web.service.impl;

import cerlace.tastetrack.web.TestConstants;
import cerlace.tastetrack.core.dto.DishIngredientDTO;
import cerlace.tastetrack.persistence.entity.DishEntity;
import cerlace.tastetrack.persistence.entity.DishIngredientEntity;
import cerlace.tastetrack.persistence.entity.IngredientEntity;
import cerlace.tastetrack.persistence.enums.MeasureUnit;
import cerlace.tastetrack.persistence.enums.ProductType;
import cerlace.tastetrack.persistence.repository.DishIngredientRepository;
import cerlace.tastetrack.persistence.repository.DishRepository;
import cerlace.tastetrack.persistence.repository.IngredientRepository;
import cerlace.tastetrack.core.service.DishIngredientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        DishIngredientService.class,
        DishIngredientRepository.class,
        DishRepository.class,
        IngredientRepository.class})
@ActiveProfiles("test")
@Transactional
class DishIngredientServiceImplTest {

    @Autowired
    private DishIngredientService dishIngredientService;

    @Autowired
    private DishIngredientRepository dishIngredientRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    private DishEntity testDish;
    private IngredientEntity testIngredient;
    private DishIngredientEntity testDishIngredient;

    @BeforeEach
    void setUp() {
        testDish = dishRepository.save(TestConstants.testDish());
        testIngredient = ingredientRepository.save(TestConstants.testIngredient());

        testDishIngredient = dishIngredientRepository.save(
                DishIngredientEntity.builder()
                        .dish(testDish)
                        .ingredient(testIngredient)
                        .measureUnit(MeasureUnit.GRAM)
                        .amount(TestConstants.AMOUNT)
                        .build()
        );
    }

    @AfterEach
    void tearDown() {
        dishIngredientRepository.deleteAll();
        dishRepository.deleteAll();
        ingredientRepository.deleteAll();
    }

    @Test
    void testSaveOrUpdate_shouldPersistEntity() {
        IngredientEntity newIngredient = ingredientRepository.save(
                IngredientEntity.builder()
                        .name(TestConstants.INGREDIENT_3_NAME)
                        .productType(ProductType.OTHER)
                        .build()
        );

        DishIngredientDTO newDto = TestConstants.newDishIngredientDTO(testDish.getId(), newIngredient.getId());

        DishIngredientDTO saved = dishIngredientService.saveOrUpdate(newDto);

        assertNotNull(saved.getId());
        assertEquals(TestConstants.AMOUNT, saved.getAmount());
        assertTrue(dishIngredientRepository.existsById(saved.getId()));
    }

    @Test
    void testGet_shouldReturnExistingEntity() {
        DishIngredientDTO result = dishIngredientService.get(testDishIngredient.getId());

        assertEquals(testDishIngredient.getId(), result.getId());
        assertEquals(testDish.getId(), result.getDish().getId());
        assertEquals(testIngredient.getId(), result.getIngredient().getId());
    }

    @Test
    void testDelete_shouldRemoveEntity() {
        assertTrue(dishIngredientRepository.existsById(testDishIngredient.getId()));

        dishIngredientService.delete(testDishIngredient.getId());

        assertFalse(dishIngredientRepository.existsById(testDishIngredient.getId()));
    }

    @Test
    void testGetIngredientsByDish_shouldReturnLinkedIngredients() {
        List<DishIngredientDTO> result = dishIngredientService.getIngredientsByDish(testDish.getId());

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(testIngredient.getId(), result.get(0).getIngredient().getId());
    }
}