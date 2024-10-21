package calculator.exception;

public enum ErrorMessage {


    EMPTY_INPUT("입력이 비어 있습니다."),
    EMPTY_CUSTOM_DELIMITER("커스텀 구분가가 비어있습니다."),
    NON_NUMERIC_VALUE("숫자가 아닌 값이 포함되었습니다."),
    NEGATIVE_VALUE("음수 값이 포함되었습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
