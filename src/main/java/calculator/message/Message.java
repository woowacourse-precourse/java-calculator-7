package calculator.message;

public enum Message {

    GET_INPUT("덧셈할 문자열을 입력해 주세요."),
    PRINT_RESULT("결과 : "),
    ILLEGAL_ARGUMENT_ERROR("올바르지 않은 형식 입니다."),
    NEGATIVE_NUMBER_ERROR("음수는 입력하시면 안됩니다.");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
