package cerlace.tastetrack.core.dto;

import cerlace.tastetrack.persistence.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DishFilter {
    private String name;
    private List<DishType> dishTypes;
    private List<Long> ingredientIds;
    private Integer minCalories;
    private Integer maxCalories;
}
