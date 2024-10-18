package calculator.common;

public enum CustomDelimiter {
    START_FORMAT("//"),
    END_FORMAT("\\n");

    private final String value;

    CustomDelimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
