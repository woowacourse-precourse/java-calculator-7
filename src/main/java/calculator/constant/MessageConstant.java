package calculator.constant;

public enum MessageConstant {
    CALCULATOR_START_MESSAGE("덧셈할 문자열을 입력해 주세요.");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }
}
