package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.ProductType;
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
public class IngredientDTO extends BaseDTO {
    private String name;
    private ProductType productType;
}
