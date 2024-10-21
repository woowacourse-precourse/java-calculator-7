package calculator.view;

public enum Message {
    INPUT_GUIDE("덧셈할 문자열을 입력해 주세요."),
    RESULT_FORMAT("결과 : ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
