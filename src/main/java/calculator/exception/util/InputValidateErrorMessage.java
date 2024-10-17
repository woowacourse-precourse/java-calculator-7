package calculator.exception.util;

public enum InputValidateErrorMessage {
    INVALID_INPUT("// 또는 숫자로 시작하는 입력을 해야 합니다.")
    ;

    private final String message;

    InputValidateErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
