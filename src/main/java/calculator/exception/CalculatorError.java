package calculator.exception;

public enum CalculatorError {
    INPUT_IS_NULL_OR_EMPTY("[Error] 입력 값이 존재하지 않습니다.");

    private final String message;

    CalculatorError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
