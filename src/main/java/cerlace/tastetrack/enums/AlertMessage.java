package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AlertMessage {
    SAVED("alert.message.saved"),
    DELETED("alert.message.deleted"),
    CONSTRAINT("alert.message.constraint"),
    PASSWORD_CONFIRM("alert.message.password-confirm"),
    LOGOUT("alert.message.logout"),
    ACCOUNT_DELETED("alert.message.account-deleted"),
    PASSWORD_CHANGED("alert.message.password-changed"),
    PROFILE_UPDATED("alert.message.profile-updated"),
    NOT_FOUND("alert.message.not-found"),
    BAD_REQUEST("alert.message.bad-request");

    private final String messageKey;
}
