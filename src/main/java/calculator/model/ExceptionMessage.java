package calculator.model;

public enum ExceptionMessage {
    NUMERIC_EXCEPTION("입력 값이 숫자가 아닙니다."),
    RANGE_EXCEPTION("숫자는 양의 정수만 입력 가능합니다."),
    EMPTY_DELIMITER_EXCEPTION("구분자는 빈 값일 수 없습니다."),
    DELIMITER_SIZE_EXCEPTION("구분자는 한 개의 문자만 이용 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
