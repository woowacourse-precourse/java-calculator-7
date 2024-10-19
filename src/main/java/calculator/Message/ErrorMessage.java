package calculator.Message;

public enum ErrorMessage {
    EMPTY_INPUT("숫자 입력이 제대로 되지 않았습니다."),
    ZERO_NOT_ALLOWED("0은 입력할 수 없습니다."),
    NEGATIVE_NUMBER_NOT_ALLOWED("음수는 입력할 수 없습니다."),
    INVALID_CHARACTER("숫자, 구분자 이외의 문자가 들어왔습니다."),
    NUMBER_TOO_LARGE("너무 큰 숫자는 입력할 수 없습니다."),
    INVALID_NUMBER_FORMAT("숫자가 너무 큽니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
