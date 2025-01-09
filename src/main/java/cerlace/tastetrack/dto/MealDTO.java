package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.MealTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MealDTO {
    private Long id;
    private Date date;
    private MealTime mealTime;
}
