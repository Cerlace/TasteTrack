package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.MealTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DietDiaryDTO {
    LocalDate startDate;
    Integer dailyLimit;
    List<LocalDate> weekDates;
    Map<LocalDate, Map<MealTime, List<MealDTO>>> groupedMeals;
    Map<LocalDate, Double> caloriesByDate;
}
