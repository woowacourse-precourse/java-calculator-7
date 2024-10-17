package calculator.enums;

public enum UIMessages {
    INPUT_REQUEST("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_RESULT("결과 : ");

    private final String message;

    UIMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
