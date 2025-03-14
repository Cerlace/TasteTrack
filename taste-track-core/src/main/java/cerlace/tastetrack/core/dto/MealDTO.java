package cerlace.tastetrack.core.dto;

import cerlace.tastetrack.persistence.enums.MealTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class MealDTO extends BaseDTO {
    private LocalDate date;
    private MealTime mealTime;
    @Builder.Default
    private UserDTO user = new UserDTO();
    @Builder.Default
    private DishDTO dish = new DishDTO();
}
