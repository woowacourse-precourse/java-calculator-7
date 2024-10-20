package calculator.global;

public enum DelimiterMarker {

    PREFIX("//"),
    SUFFIX("\\n");

    private final String key;

    DelimiterMarker(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
