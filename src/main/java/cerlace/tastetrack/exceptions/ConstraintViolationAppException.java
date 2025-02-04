package cerlace.tastetrack.exceptions;

import cerlace.tastetrack.enums.ConstraintType;
import lombok.Getter;

@Getter
public class ConstraintViolationAppException extends RuntimeException {
    private final ConstraintType constraintType;

    public ConstraintViolationAppException(String message, ConstraintType constraintType) {
        super(message);
        this.constraintType = constraintType;
    }
}
