package global;

public enum DefaultDelimiter {

    COMMA(","),
    COLON(":");

    private final String key;

    DefaultDelimiter(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
