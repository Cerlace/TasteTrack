package cerlace.tastetrack.core.dto;

import cerlace.tastetrack.persistence.enums.MeasureUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @Builder.Default
    private DishDTO dish = new DishDTO();
    @Builder.Default
    private IngredientDTO ingredient = new IngredientDTO();
    private Float amount;
    private MeasureUnit measureUnit;
}
