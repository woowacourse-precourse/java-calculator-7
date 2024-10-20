package calculator.view;

public enum Message {

    INSTRUCTION_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    INVALID_DELIMITER_ORDER("'//'는 '\\n'보다 앞에 위치해야 합니다."),
    INVALID_DELIMITER_POSITION("'//'와 '\\n'이 모두 존재해야 합니다."),
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
