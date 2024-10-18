package calculator.exception.util;

public enum NumberExtractorErrorMessage {
    INVALID_DELIMITER("잘못된 구분자를 포함하고 있습니다."),
    NEGATIVE_OR_ZERO_NUMBER("0 또는 음수를 포함하고 있습니다."),
    INVALID_CHARACTER("유효하지 않은 문자를 포함하고 있습니다."),
    INVALID_SPLIT("분리할 수 없는 문자를 포함하고 있습니다."),
    OUT_OF_INT_RANGE("int 범위를 벗어났습니다."),
    NOT_AN_INTEGER("정수가 아닌 숫자를 포함하고 있습니다.");

    private final String message;

    NumberExtractorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
