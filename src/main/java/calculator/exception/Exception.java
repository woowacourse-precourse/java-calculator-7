package calculator.exception;

public enum Exception {
    INVALID_CUSTOM_DELIMITER("올바르지 않은 형식입니다. 커스텀 구분자는 '//'와 '\\n' 사이에 위치해야 합니다."),
    INVALID_FORMAT("올바르지 않은 형식입니다."),
    INVALID_NEGATIVE_NUMBER("음수 입력은 불가합니다."),
    EMPTY_CUSTOM_DELIMITER("올바르지 않은 형식입니다. 커스텀 구분자는 빈 문자열이 불가합니다."),
    NUMERIC_CUSTOM_DELIMITER("올바르지 않은 형식입니다. 커스텀 구분자는 숫자 형식이 불가합니다."),
    CUSTOM_DELIMITER_TOO_LONG("올바르지 않은 형식입니다. 커스텀 구분자는 1글자의 문자만 가능합니다."),
    NUMERIC_TOO_LONG("올바르지 않은 형식입니다. 숫자는 10자리를 넘을 수 없습니다."),
    INCORRECT_DELIMITER_PLACEMENT("올바르지 않은 형식입니다. 커스텀 구분자는 문자열 맨 앞에 정의해야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
