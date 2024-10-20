package calculator.message;

public enum ErrorMessage implements MessageProvider{

    EMPTY_INPUT("입력값이 비어 있습니다."),
    INVALID_INPUT("유효하지 않은 입력입니다."),
    INVALID_WHITESPACE("공백은 허용되지 않습니다."),
    INVALID_NUMBER_FORMAT("잘못된 숫자 형식입니다."),
    INVALID_CHARACTER("구분자 외의 문자가 포함되어 있습니다."),
    NOT_ALLOWED_NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    INTEGER_OUT_OF_RANGE("표현 가능 범위를 초과하였습니다."),
    MISSING_CUSTOM_DELIMITER_END("잘못된 커스텀 문자입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
