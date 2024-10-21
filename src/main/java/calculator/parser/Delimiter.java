package calculator.parser;

public enum Delimiter {
    COMMA(","),
    COLON(":"),
    CUSTOM_START("//"),
    CUSTOM_END("\\n");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


