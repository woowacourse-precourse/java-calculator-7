package calculator.message;

public enum Message {

    GET_INPUT("덧셈할 문자열을 입력해 주세요."),
    ILLEGAL_ARGUMENT_ERROR("올바르지 않은 형식 입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
