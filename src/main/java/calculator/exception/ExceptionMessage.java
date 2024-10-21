package calculator.exception;

public enum ExceptionMessage {
    INVALID_INPUT_VALUE("잘못된 문자열입니다."),
    INVALID_INTEGER_TYPE("음수를 입력하었습니다."),
    INVALID_DELIMITER("잘못된 구분자를 입력하였습니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
