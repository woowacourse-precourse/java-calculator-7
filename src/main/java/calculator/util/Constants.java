package calculator.util;

public enum Constants {
    PROGRAM_START("덧셈할 문자열을 입력해 주세요."),
    PROGRAM_END("결과 : "),
    NULL_INPUT("입력 값이 NULL 입니다."),
    ;

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
