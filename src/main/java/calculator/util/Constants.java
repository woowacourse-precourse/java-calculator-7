package calculator.util;

public enum Constants {

    INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요. "),
    OUTPUT_MESSAGE("결과 : "),
    ERROR_NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    ERROR_INVALID_INPUT("잘못된 입력값이 포함되었습니다.");

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
