package calculator.exception.constants;

public enum ErrorMessage {

    INVALID_INPUT_VALUE("잘못된 값을 입력하셨습니다."),
    INVALID_NON_POSITIVE_VALUE("양수가 아닌 값을 입력하셨습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
