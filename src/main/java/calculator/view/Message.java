package calculator.view;

public enum Message {

    INSTRUCTION_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    NO_INPUT("입력이 없습니다."),
    RESULT_MESSAGE("결과 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
