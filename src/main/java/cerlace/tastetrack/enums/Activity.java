package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Activity {
    LOW("activity.low"),
    AVERAGE("activity.average"),
    HIGH("activity.high");

    private final String messageKey;
}
