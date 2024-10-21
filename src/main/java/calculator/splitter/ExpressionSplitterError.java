package calculator.splitter;

public enum ExpressionSplitterError {

    INVALID_EXPRESSION("유효하지 않은 표현식입니다.");

    private final String message;

    ExpressionSplitterError(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

}
