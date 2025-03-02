package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.DishType;
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
    private Integer minCalories;
    private Integer maxCalories;
}
