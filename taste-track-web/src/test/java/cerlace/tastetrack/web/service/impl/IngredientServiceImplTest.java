package cerlace.tastetrack.web.service.impl;

import cerlace.tastetrack.web.TestConstants;
import cerlace.tastetrack.core.dto.IngredientDTO;
import cerlace.tastetrack.core.dto.PageSettings;
import cerlace.tastetrack.persistence.repository.IngredientRepository;
import cerlace.tastetrack.core.service.IngredientService;
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
        IngredientService.class,
        IngredientRepository.class})
@ActiveProfiles("test")
@Transactional
class IngredientServiceImplTest {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp() {
        ingredientRepository.saveAll(TestConstants.testIngredients());
    }

    @AfterEach
    void tearDown() {
        ingredientRepository.deleteAll();
    }

    @Test
    void testSaveOrUpdate_shouldPersistEntity() {
        IngredientDTO newDto = TestConstants.newIngredientDTO();

        IngredientDTO saved = ingredientService.saveOrUpdate(newDto);

        assertNotNull(saved.getId());
        assertEquals(TestConstants.NEW_INGREDIENT_NAME, saved.getName());
        assertTrue(ingredientRepository.existsById(saved.getId()));
    }

    @Test
    void testGet_shouldReturnExistingEntity() {
        Long targetId = ingredientRepository.findByName(TestConstants.INGREDIENT_1_NAME).getId();

        IngredientDTO result = ingredientService.get(targetId);

        assertEquals(targetId, result.getId());
        assertEquals(TestConstants.INGREDIENT_1_NAME, result.getName());
    }

    @Test
    void testGetAll_shouldReturnAllEntities() {
        List<IngredientDTO> result = ingredientService.getAll();

        assertEquals(TestConstants.testIngredients().size(), result.size());
    }

    @Test
    void testGetPage_shouldReturnPagedResults() {
        PageSettings pageSettings = TestConstants.ingredientsFirstPage();

        Page<IngredientDTO> page = ingredientService.getPage(pageSettings);

        assertEquals(TestConstants.testIngredients().size(), page.getTotalElements());
        assertEquals(TestConstants.PAGE_SIZE, page.getNumberOfElements());
    }

    @Test
    void testDelete_shouldRemoveEntity() {
        Long targetId = ingredientRepository.findByName(TestConstants.INGREDIENT_1_NAME).getId();

        assertTrue(ingredientRepository.existsById(targetId));

        ingredientService.delete(targetId);

        assertFalse(ingredientRepository.existsById(targetId));
    }
}