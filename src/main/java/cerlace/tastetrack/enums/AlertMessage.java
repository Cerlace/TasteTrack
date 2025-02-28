package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AlertMessage {
    SAVED("alert.message.saved"),
    DELETED("alert.message.deleted"),
    CONSTRAINT("alert.message.constraint");

    private final String messageKey;
}
