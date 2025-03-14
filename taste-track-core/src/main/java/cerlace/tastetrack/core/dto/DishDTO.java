package cerlace.tastetrack.core.dto;

import cerlace.tastetrack.persistence.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class DishDTO extends BaseDTO {
    private String name;
    private DishType dishType;
    private Float calories;
    private Float proteins;
    private Float fats;
    private Float carbohydrates;
    private String recipe;
    private Set<DishIngredientDTO> dishIngredients;
}
