package calculator.global;

public enum MakeRegexDelimiter {

    START("//"), // 시작 구분자
    OPEN_BRACKET("["), // 여는 대괄호
    CLOSE_BRACKET("]"); // 닫는 대괄호

    private final String key;

    MakeRegexDelimiter(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
