package calculator.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어 있습니다. 덧셈할 문자열을 입력해주세요."),
    INVALID_CUSTOM_DELIMITER("커스텀 구분자 사용이 잘못되었습니다."),
    NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    INVALID_NUMBER_FORMAT("잘못된 숫자 입력이 포함되어 있습니다.");


    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

