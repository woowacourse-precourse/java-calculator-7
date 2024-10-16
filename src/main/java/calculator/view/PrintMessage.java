package calculator.view;

public enum PrintMessage {

    USER_INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
