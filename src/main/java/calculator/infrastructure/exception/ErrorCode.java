package calculator.infrastructure.exception;

public enum ErrorCode {
    INPUT_IS_NOT_TRIMMED("입력 문자열에 불필요한 공백이 포함되어 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
