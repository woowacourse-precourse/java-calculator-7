package calculator;

public enum DefaultDelimiter {

    DEFAULT_DELIMITER(":|,");

    private final String delimiter;

    DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
