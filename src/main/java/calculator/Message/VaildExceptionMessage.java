package calculator.Message;

public enum VaildExceptionMessage {
    INVALID_SEPARATOR_FORMAT("구분자를 정확하게 입력해주세요."),
    BASIC_SEPARATOR_AS_CUSTOM("기본 구분자를 커스텀 구분자로 사용할 수 없습니다."),
    DIGIT_AS_SEPARATOR("숫자는 구분자로 사용할 수 없습니다.");

    private final String message;

    VaildExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}