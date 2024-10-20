package calculator.front.exception;

public enum FrontExceptionMessage {
    NUMBER_AS_DELIMITER_EXCEPTION("숫자는 커스텀 구분자가 될 수 없습니다.");

    FrontExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    private final String exceptionMessage;

    public String getMessage() {
        return this.exceptionMessage;
    }
}