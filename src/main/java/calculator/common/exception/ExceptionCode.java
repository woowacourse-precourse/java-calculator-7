package calculator.common.exception;

public enum ExceptionCode {

    NUMBER_INVALID_NEGATIVE("C001", "입력 값에는 음수가 포함될 수 없습니다."),
    NUMBER_INVALID_ZERO("C002", "입력 값에는 0이 포함될 수 없습니다.");

    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
