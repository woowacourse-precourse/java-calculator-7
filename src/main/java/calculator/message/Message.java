package calculator.message;

public enum Message {
    INPUT_PROMPT("덧셈할 문자열을 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
