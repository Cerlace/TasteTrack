package cerlace.tastetrack.dto;

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
public class DishDTO extends BaseDTO {
    private String name;
    private Float calories;
    private Float proteins;
    private Float fats;
    private Float carbohydrates;
    private String recipe;
}
