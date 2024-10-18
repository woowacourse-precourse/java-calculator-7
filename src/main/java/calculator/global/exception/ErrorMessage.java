package calculator.global.exception;

public enum ErrorMessage {
    INVALID_DELIMITER_ERROR("올바르지 않은 구분자 입력입니다."),
    NOT_NUMBER_ERROR("구분자 사이에 숫자를 입력해주세요."),
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NEGATIVE_NUMBER_ERROR("음수는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
