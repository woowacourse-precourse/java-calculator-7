package calculator.global.exception;

public enum ErrorMessage {

    INVALID_DELIMITER_START("The input must start with '//' for custom delimiter."),
    EMPTY_CUSTOM_DELIMITER("Custom delimiter cannot be empty after '//'.");
    

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
