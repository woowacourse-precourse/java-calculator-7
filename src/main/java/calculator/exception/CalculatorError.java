package calculator.exception;

public enum CalculatorError {
    INPUT_IS_NULL_OR_EMPTY("[Error] 입력 값이 존재하지 않습니다."),
    DELIMITER_IS_NUMBER("[Error] 구분자는 숫자가 될 수 없습니다."),
    DELIMITER_IS_EMPTY("[Error] 구분자는 비어 있거나 공백만 포함될 수 없습니다."),
    INPUT_CONTAINS_NEGATIVE("[Error] 음수는 입력할 수 없습니다.");

    private final String message;

    CalculatorError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
