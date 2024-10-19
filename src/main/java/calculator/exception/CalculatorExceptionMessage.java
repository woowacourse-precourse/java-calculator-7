package calculator.exception;

public enum CalculatorExceptionMessage {

    INVALID_PARAMETER_EXCEPTION("잘못된 값 입니다."),
    MULTIPLE_CUSTOM_DELIMITERS_EXCEPTION("구분자는 1개만 허용합니다."),
    DELIMITER_MUST_ACCEPT_SINGLE("구분자는 1개만 허용합니다."),
    DELIMITER_MUST_ACCEPT_NO_NUMBER("구분자에는 숫자가 올 수 없습니다."),
    DELIMITER_CANT_BLANK("구분자에는 숫자가 올 수 없습니다.");

    private final String errorMessage;

    CalculatorExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
