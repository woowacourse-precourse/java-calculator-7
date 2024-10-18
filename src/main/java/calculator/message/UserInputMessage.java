package calculator.message;

public enum UserInputMessage implements MessageType {

    REQUEST_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    ;

    private final String message;

    UserInputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
