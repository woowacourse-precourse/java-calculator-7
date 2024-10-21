package calculator.errors;

public enum InputError {
    NEGATIVE("음수는 허용되지 않습니다: "),
    OUT_OF_RANGE("입력된 숫자가 int 범위를 벗어났습니다: "),
    INVALID_FORMAT("올바르지 않은 숫자 형식입니다: "),
    INVALID_DELIMITER("올바르지 않은 구분자 형식입니다.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}