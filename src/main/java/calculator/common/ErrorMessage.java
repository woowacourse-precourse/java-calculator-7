package calculator.common;

public enum ErrorMessage {
    INVALID_INPUT("유효하지 않은 계산식입니다."),
    INVALID_NUMBER_FORMAT("숫자의 형식이 잘못되었습니다."),
    NON_POSITIVE_NUMBER("양수만 입력할 수 있습니다."),
    INVALID_REGEX("정규 표현식이 잘못되었습니다."),
    DUPLICATE_DEFAULT_DELIMITER("기본 구분자는 커스텀 구분자로 지정할 수 없습니다."),
    DUPLICATE_DELIMITER("커스텀 구분자를 중복하여 지정할 수 없습니다."),
    NUMERIC_DELIMITER_NOT_ALLOWED("커스텀 구분자로 숫자를 지정할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
