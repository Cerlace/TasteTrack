package cerlace.tastetrack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DishIngredientDTO {
    private Long id;
    private DishDTO dish;
    private IngredientDTO ingredient;
    private Float amount;
}
