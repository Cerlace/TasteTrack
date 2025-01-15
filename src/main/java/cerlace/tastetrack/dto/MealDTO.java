package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.MealTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class MealDTO extends BaseDTO {
    private Date date;
    private MealTime mealTime;
}
