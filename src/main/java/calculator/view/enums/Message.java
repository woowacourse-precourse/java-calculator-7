package calculator.view.enums;

public enum Message {
    INPUT_REQUEST_PROMPT("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_RESULT_PROMPT("결과 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
