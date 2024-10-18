package global;

public enum ErrorCode {
    NOT_ALLOWED_NEGATIVE("음수값은 허용되지 않습니다."),
    WRONG_INPUT("구분자와 숫자가 아닌 값을 입력하셨습니다."),
    INVALID_CUSTOM_REQUEST("커스텀 구분자는 //와 \\n 사이에 있어야 합니다."),
    TO0_MUCH_SEPARATORS("구분자는 숫자 사이에 하나씩 있어야 합니다."),

    ;

    public final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
