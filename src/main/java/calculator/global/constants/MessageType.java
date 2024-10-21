package calculator.global.constants;

public enum MessageType {
    STRING_REQUEST_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    EMPTY_INPUT_ERROR("비어있는 숫자가 입력되었습니다."),
    NON_NUMERIC_INPUT_ERROR("숫자가 아닌 잘못된 입력입니다: "),
    NEGATIVE_NUMBER_ERROR("음수는 허용되지 않습니다: "),
    RESULT_MESSAGE("결과 : ");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}