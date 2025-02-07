package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Goal {
    LOSE_WEIGHT("goal.lose"),
    KEEP_WEIGHT("goal.keep"),
    GAIN_WEIGHT("goal.gain");

    private final String messageKey;
}
