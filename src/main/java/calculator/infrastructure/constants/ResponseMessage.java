package calculator.infrastructure.constants;

public enum ResponseMessage {
    REQUEST_INPUT_MESSAGE("덧셈할 문자열을 입력해주세요.");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
