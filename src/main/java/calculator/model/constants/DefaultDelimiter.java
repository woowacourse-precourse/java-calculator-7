package calculator.model.constants;

public enum DefaultDelimiter {
    COMMA(","),
    COLON(":");

    private final String value;

    DefaultDelimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
