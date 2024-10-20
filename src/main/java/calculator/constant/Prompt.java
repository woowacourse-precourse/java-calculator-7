package calculator.constant;

public enum Prompt {
    PROMPT_INPUT("덧셈할 문자열을 입력해 주세요."),
    RESULT("결과 : ");

    private final String text;

    Prompt(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
