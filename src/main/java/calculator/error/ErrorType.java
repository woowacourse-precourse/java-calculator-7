package calculator.error;

public enum ErrorType {
    INPUT_FORMAT_ERROR("숫자나 올바른 형식의 커스텀 구분자를 입력해주세요.(//(커스텀 구분자)\\n)"),
    INPUT_NEGATIVE_NUMBER_ERROR("양수를 입력해주세요."),
    EMPTY_CUSTOM_SEPARATOR_ERROR("커스텀 구분자를 입력해주세요.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
