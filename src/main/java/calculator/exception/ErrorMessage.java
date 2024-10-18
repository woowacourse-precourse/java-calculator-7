package calculator.exception;

public enum ErrorMessage {

    INPUT_TYPE_ERROR("잘못된 값을 입력했습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
