package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.MealTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class MealDTO extends BaseDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private MealTime mealTime;
    @Builder.Default
    private UserDTO user = new UserDTO();
    @Builder.Default
    private DishDTO dish = new DishDTO();
}
