package calculator.global.exception;

public enum ErrorMessage {

    EMPTY_INPUT("The input is empty."),
    INVALID_DELIMITER_START("The input must start with '//' for custom delimiter."),
    EMPTY_CUSTOM_DELIMITER("Custom delimiter cannot be empty after '//'."),
    EMPTY_NUMBER_INPUT("The number cannot be empty."),
    INVALID_STRING_START("The input must start with number"),
    INVALID_STRING_END("The input must end with number"),
    INVALID_DELIMITER_INPUT("The String currently has an incorrect delimiter."),
    EMPTY_NUMBERS_INPUT("The numbers cannot be empty.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
