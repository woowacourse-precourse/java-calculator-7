package calculator.error;

public enum ErrorType {
    INPUT_FORMAT_ERROR("숫자를 입력해주세요."),
    INPUT_NEGATIVE_NUMBER_ERROR("양수를 입력해주세요.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
