package calculator.view;

public enum Output {
    INPUT_STRING("덧셈할 문자열을 입력해 주세요.");

    private String message;

    Output(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
