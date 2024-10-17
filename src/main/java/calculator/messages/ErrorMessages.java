package calculator.messages;

public enum ErrorMessages {
    EXIST_SEPARTOR("이미 존재하는 구분자입니다."),
    INVALID_INPUT("유효하지 않은 입력입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
