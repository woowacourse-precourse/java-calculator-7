package calculator.model.delimiter;

public enum DefaultDelimiterType {
    COMMA(","),
    COLON(":");

    private final String value;

    DefaultDelimiterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
