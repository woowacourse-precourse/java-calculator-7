package calculator.exception;

public enum ExceptionMessage {
    EMPTY_INPUT("공백은 입력할 수 없습니다."),
    MINUS_OR_ZERO_INPUT("음수 또는 0은 입력할 수 없습니다."),
    BOUNDARY_DELIMITER("경계값에 구분자가 들어갈 수 없습니다."),
    NOT_DELIMITER_OR_NUMBER("숫자와 구분자를 제외한 문자는 입력할 수 없습니다."),
    DUPLICATE_DELIMITER("구분자를 연속해서 입력할 수 없습니다."),
    FORBIDDEN_WORDS_IN_DELIMITER("커스텀 구분자에 숫자와 '-'를 포함할 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
