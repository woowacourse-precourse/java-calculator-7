package calculator.view.enums;

public enum Message {
    REQUEST_INPUT("덧셈할 문자열을 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
