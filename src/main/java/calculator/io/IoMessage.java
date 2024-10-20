package calculator.io;

public enum IoMessage {
    ENTRY("덧셈할 문자열을 입력해 주세요."),
    RESULT("결과 : ");

    private final String description;

    IoMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}