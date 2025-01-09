package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class IngredientDTO {
    private Long id;
    private String name;
    private ProductType productType;
}
