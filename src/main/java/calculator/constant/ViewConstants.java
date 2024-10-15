package calculator.constant;

public enum ViewConstants {
    //input
    INPUT_STRING("덧셈할 문자열을 입력해 주세요."),

    //output
    OUTPUT_STRING("결과 : %d");

    private final String message;

    ViewConstants(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
