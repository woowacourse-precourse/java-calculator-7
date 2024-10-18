package calculator.common.exception;

public enum ExceptionCode {

    NUMBER_INVALID_NEGATIVE("C001", "입력 값에는 음수가 포함될 수 없습니다."),
    NUMBER_INVALID_ZERO("C002", "입력 값에는 0이 포함될 수 없습니다."),
    INVALID_CUSTOM_DELIMITER_PATTERN("C003", "유효하지 않은 커스텀 구분자입니다."),
    INVALID_DEFAULT_DELIMITER_USED("C004", "연산식에 올바르지 않은 기본 구분자가 포함되어 있습니다."),
    INVALID_CUSTOM_DELIMITER_USED("C005", "연산식에 올바르지 않은 커스텀 구분자가 포함되어 있습니다."),
    INVALID_NUMBER_USED("C006", "연산식에 유효하지 않은 숫자가 포함되어 있습니다."),
    ;

    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
