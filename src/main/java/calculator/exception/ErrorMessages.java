package calculator.exception;

public enum ErrorMessages {

    INCLUDES_NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),
    INCLUDES_NON_NUMERIC("숫자가 아닌 문자는 입력할 수 없습니다.");

    private final String message;

    ErrorMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
