package cerlace.tastetrack.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Gender {
    MALE("gender.male"),
    FEMALE("gender.female");

    private final String messageKey;
}
