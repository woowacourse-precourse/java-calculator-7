package calculator.exception;

public enum CalculatorExceptionMessage {

    INVALID_PARAMETER_EXCEPTION("잘못된 값 입니다."),
    MULTIPLE_CUSTOM_DELIMITERS_EXCEPTION("구분자는 1개만 허용합니다."),
    DELIMITER_MUST_ACCEPT_SINGLE("구분자는 1개만 허용합니다.");

    private final String errorMessage;

    CalculatorExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
