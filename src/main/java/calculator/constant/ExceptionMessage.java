package calculator.constant;

public enum ExceptionMessage {

    NOT_INTEGER("숫자를 입력해주세요."),
    NOT_POSITIVE("양수만 입력할 수 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
