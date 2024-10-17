package calculator.exception;

public enum CalculatorExceptionMessage {

    INVALID_PARAMETER_EXCEPTION("잘못된 값 입니다.");

    private final String errorMessage;

    CalculatorExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
