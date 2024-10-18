package calculator.constant;

public enum ErrorMessage {
    NEGATIVE_NUMBER_INPUT("음수는 입력할 수 없어요"),
    NOT_A_NUMBER("숫자만 입력할 수 있어요"),
    CAN_USE_ONLY_STRING("구분자는 문자만 입력할 수 있어요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
