package calculator.view;

public enum ViewMessage {

    // 입력 관련 메시지
    INPUT_PROMPT("덧셈할 문자열을 입력해 주세요."),

    // 출력 관련 메시지
    RESULT_MESSAGE("결과 : ");
    
    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
