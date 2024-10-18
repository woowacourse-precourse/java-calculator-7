package calculator.exception.constants;

public enum ErrorMessage {

    INVALID_INPUT_VALUE("잘못된 값을 입력하셨습니다."),
    NEGATIVE_VALUE_NOT_ALLOWED("음수는 입력할 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
