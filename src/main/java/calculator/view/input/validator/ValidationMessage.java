package calculator.view.input.validator;

public enum ValidationMessage {
    INVALID_INPUT_STRING("입력 문자열에 잘못된 값이 입력되었습니다."),
    INPUT_NEGATIVE_NUMERIC("입력 문자열에 음수가 포함되어 있습니다.");

    private final String message;

    ValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
