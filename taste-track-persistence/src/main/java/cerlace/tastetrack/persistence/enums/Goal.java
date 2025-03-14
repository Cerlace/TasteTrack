package cerlace.tastetrack.persistence.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Goal {
    LOSE_WEIGHT("goal.lose", -500),
    KEEP_WEIGHT("goal.keep", 0),
    GAIN_WEIGHT("goal.gain", 500);

    private final String messageKey;
    private final int caloriesCorrection;
}
