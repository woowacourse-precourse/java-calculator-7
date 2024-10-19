package calculator.exception;

public enum ExceptionMessage {
    EMPTY_INPUT("공백은 입력할 수 없습니다."),
    MINUS_OR_ZERO_INPUT("음수 또는 0은 입력할 수 없습니다."),
    BOUNDARY_DELIMITER("경계값에는 구분자가 들어갈 수 없습니다."),
    NOT_DELIMITER("구분자가 아닌 문자는 입력할 수 없습니다."),
    DUPLICATE_DELIMITER("구분자를 중첩해서 입력할 수 없습니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
