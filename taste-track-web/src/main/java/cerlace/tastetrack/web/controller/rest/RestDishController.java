package cerlace.tastetrack.web.controller.rest;

import cerlace.tastetrack.core.dto.DishDTO;
import cerlace.tastetrack.core.dto.IngredientDTO;
import cerlace.tastetrack.core.service.DishService;
import cerlace.tastetrack.core.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestDishController {

    private final DishService dishService;
    private final IngredientService ingredientService;

    @GetMapping(value = "/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DishDTO> getAllDishes() {
        return dishService.getAll();
    }

    @GetMapping(value = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IngredientDTO> getAllIngredients() {
        return ingredientService.getAll();
    }
}
