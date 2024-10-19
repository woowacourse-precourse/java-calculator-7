package calculator.view.enums;

public enum Message {
    INPUT_REQUEST_PROMPT("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_RESULT_PROMPT("결과 : "),

    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자 설정 형식이 잘못되었습니다. 커스텀 구분자는 '%s'로 끝나야 합니다."),
    INVALID_CUSTOM_DELIMITER_LENGTH("커스텀 구분자는 1자리 문자여야 하며 숫자가 될 수 없습니다."),
    INVALID_INPUT_VALUE("입력 값은 구분자와 양수로 구성된 문자열이어야 합니다."),
    END_OF_INPUT("문자열의 끝에 도달했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }

    public String getMessage() {
        return message;
    }
}
