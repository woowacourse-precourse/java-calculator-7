package calculator.exception.util;

public enum NumberExtractorErrorMessage {
    NEGATIVE_OR_ZERO_NUMBER("0 또는 음수를 포함하고 있습니다."),
    INVALID_CHARACTER("잘못된 문자를 포함하고 있습니다. (잘못된 구분자 또는 정수가 아닌 문자가 포함된 경우)"),
    INVALID_SPLIT("분리할 수 없는 문자를 포함하고 있습니다."),
    OUT_OF_INT_RANGE("int 범위를 벗어났습니다.");

    private final String message;

    NumberExtractorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
