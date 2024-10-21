package calculator.util;

public enum ExceptionMessage {
    INVALID_DELIMITER("Invalid delimiter('.' or number not allowed)"),
    INVALID_NUMBER_FORMAT("Invalid decimal format(Only valid in the format 'number.number')"),
    NEGATIVE_INPUT("Negative values not allowed")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
