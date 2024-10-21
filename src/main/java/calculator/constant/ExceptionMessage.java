package calculator.constant;

public enum ExceptionMessage {
    INVALID_NUMBER_FORMAT("유효하지 않은 숫자 형식입니다: %s\n양의 정수만 사용 가능하며, 소수점, 공백, 문자, 특수 문자는 사용할 수 없습니다."),
    NOT_POSITIVE_NUMBER("숫자는 양수여야 합니다."),
    DELIMITER_NULL_OR_EMPTY("구분자는 null 이거나 비어있을 수 없습니다."),
    DELIMITER_RESERVED_CHARACTER("구분자에는 '//' 나 '\\n' 가 포함될 수 없습니다."),
    CUSTOM_DELIMITERS_NULL("커스텀 구분자목록은 null 일 수 없습니다."),
    CUSTOM_DELIMITER_POSITION("커스텀 구분자는 문자열의 시작 부분에만 위치해야 합니다."),
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자 형식이 올바르지 않습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
