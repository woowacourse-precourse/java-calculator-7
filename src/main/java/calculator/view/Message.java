package calculator.view;

public enum Message {

    INCLUDE_NEGATIVE_NUMBER("음수가 포함되어 있습니다."),
    INCLUDE_NOT_NUMBER("숫자가 아닌 값이 포함되어 있습니다."),
    INSTRUCTION_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    INVALID_DELIMITER_ORDER("'//'는 '\\n'보다 앞에 위치해야 합니다."),
    INVALID_DELIMITER_POSITION("'//'와 '\\n'이 모두 존재해야 합니다."),
    INVALID_NUMERIC_CUSTOM_DELIMITER("커스텀 구분자는 숫자가 될 수 없습니다."),
    NO_INPUT("입력이 없습니다."),
    ONLY_ONE_CUSTOM_DELIMITER("커스텀 구분자는 한 개 이어야 합니다."),
    RESULT_MESSAGE("결과 : "),
    TOO_BIG_NUMBER("숫자가 너무 큽니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
