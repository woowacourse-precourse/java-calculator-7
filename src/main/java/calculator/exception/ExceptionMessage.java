package calculator.exception;

public enum ExceptionMessage {

    INVALID_DELIMITER_FORMAT("잘못된 구분자 형식입니다."),
    INVALID_NUMBER_FORMAT("잘못된 숫자 형식입니다: "),
    NEGATIVE_NUMBER("양수만 입력할 수 있습니다: "),
    EMPTY_DELIMITER("구분자가 비어 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
