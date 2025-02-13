package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DishType {
    MAIN("dish-type.main"),
    SOUP("dish-type.soup"),
    BREAKFAST("dish-type.breakfast"),
    SNACK("dish-type.snack"),
    SALAD("dish-type.salad"),
    DESSERT("dish-type.dessert");

    private final String messageKey;
}
