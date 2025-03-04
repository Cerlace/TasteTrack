package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Activity {
    LOW("activity.low", 1.2),
    AVERAGE("activity.average", 1.55),
    HIGH("activity.high", 1.725);

    private final String messageKey;
    private final double multiplier;
}
