package calculator.enums;

public enum ErrorMessage {
    INPUT_IS_NULL("Input is null"),
    INVALID_CUSTOM_SEPARATOR_LENGTH("Length of custom separator is must 1"),
    INVALID_CUSTOM_SEPARATOR_SYNTAX("Invalid custom separator syntax"),
    CUSTOM_SEPARATOR_IS_NUMBER("Custom separator must not be a number"),
    INVALID_OPERAND("Invalid operand format")

    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
