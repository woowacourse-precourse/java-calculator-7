package calculator.parser;

public enum Delimiter {
    COMMA(","),
    COLON(":");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


