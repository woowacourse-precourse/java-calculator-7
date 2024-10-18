package calculator.errorMessage;

public enum ErrorMessage {
    NEGATIVE_NUMBER("음수가 포함되어 있습니다."),
    INVALID_NUMBER_FORMAT("잘못된 숫자 형식입니다."),
    INVALID_CUSTOM_DELIMITER("커스텀 구분자 지정 형식이 잘못 되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}