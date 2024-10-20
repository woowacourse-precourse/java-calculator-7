package calculator;

public enum Delimiter {
    CUSTOM_SEPARATOR_START("//"),
    CUSTOM_SEPARATOR_END("\\n"),
    OR("|"),
    BRACKET_OPEN("["),
    BRACKET_CLOSE("]");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
