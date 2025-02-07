package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MealTime {
    BREAKFAST("meal-time.breakfast"),
    LUNCH("meal-time.lunch"),
    DINNER("meal-time.dinner");

    private final String messageKey;
}
