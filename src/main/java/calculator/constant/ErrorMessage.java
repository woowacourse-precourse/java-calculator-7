package calculator.constant;

public enum ErrorMessage {

    INVALID_INPUT("유효하지 않은 입력입니다."),
    REQUIRED_POSITIVE_NUMBER("양수로 구성된 문자열을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}