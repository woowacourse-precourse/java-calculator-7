package calculator.util.exception;

public enum ErrorMessage {
    LOW_THEN_ZERO("숫자는 0 이상이어야 합니다."),
    CUSTOM_DELIMITER_NOT_ALLOW_MULTIPLE("커스텀 구분자는 하나의 문자여야 합니다."),
    IS_NOT_NUMBER_VALUE("정수로 변환이 불가능한 문자열이 존재합니다."),
    CUSTOM_DELIMITER_NEED_NEWLINE("커스텀 구분자 정의 후 줄바꿈이 필요합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
