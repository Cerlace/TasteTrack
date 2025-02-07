package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.MeasureUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class DishIngredientDTO extends BaseDTO {
    private DishDTO dish;
    private IngredientDTO ingredient;
    private Float amount;
    private MeasureUnit measureUnit;
}
