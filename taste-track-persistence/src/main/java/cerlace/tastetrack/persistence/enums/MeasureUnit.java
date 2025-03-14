package cerlace.tastetrack.persistence.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MeasureUnit {
    GRAM("unit.gram"),
    MILLILITER("unit.milliliter"),
    LITER("unit.liter"),
    TEASPOON("unit.teaspoon"),
    TABLESPOON("unit.tablespoon"),
    CUP("unit.cup"),
    PIECE("unit.piece");

    private final String messageKey;
}
