package calculator;

public enum Delimiter {

    PREFIX("//"),
    SUFFIX("\\n"),
    DEFAULT_DELIMITER(":|,");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
