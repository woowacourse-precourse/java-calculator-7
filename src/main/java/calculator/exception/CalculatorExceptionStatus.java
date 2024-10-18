package calculator.exception;

public enum CalculatorExceptionStatus {

    INVALID_DEFAULT_DELIMITER_EXPRESSION("잘못된 입력 형식입니다"),
    INVALID_CUSTOM_DELIMITER_EXPRESSION("수식에 올바르지 않은 커스텀 구분자가 들어갔습니다"),
    INVALID_NEGATIVE_INTEGER("양수만 입력 가능합니다"),
    INVALID_CUSTOM_DELIMITER_INTEGER("커스텀 구분자로 숫자를 사용할 수 없습니다.");

    private final String errorMessage;

    CalculatorExceptionStatus(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return this.errorMessage;
    }
}
