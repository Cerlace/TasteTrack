package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AlertMessage {
    SAVED("alert.message.saved"),
    DELETED("alert.message.deleted"),
    CONSTRAINT("alert.message.constraint"),
    PASSWORD_CONFIRM("alert.message.password-confirm");

    private final String messageKey;
}
