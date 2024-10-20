package calculator.global.constants;

public enum MessageType {
    STRING_REQUEST_MESSAGE("덧셈할 문자열을 입력해 주세요.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}