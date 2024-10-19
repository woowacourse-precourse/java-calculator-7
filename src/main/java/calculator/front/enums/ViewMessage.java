package calculator.front.enums;

public enum ViewMessage {
    INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_MESSAGE("결과 : ");

    ViewMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
