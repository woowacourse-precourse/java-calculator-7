package calculator.exception;

public enum ErrorStatus {
    // input
    INVALID_INPUT("숫자가 아닌 문자가 포함되어 있습니다."),
    TOO_BIG_NUMBER("계산기가 처리할 수 있는 최대 숫자보다 큰 숫자가 입력되었습니다."),
    ZERO_NOT_ALLOWED("양수만 입력 가능합니다."),

    // custom delimiter,
    DELIMITER_CONTAINS_NUMBER("구분자는 숫자가 될 수 없습니다."),
    DELIMITER_INVALID_LENGTH("구분자의 길이는 1글자여야 합니다."),

    // calculator
    ADDITION_OVERFLOW("더하기 연산 중 오버플로우가 발생했습니다."),
    ;

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
