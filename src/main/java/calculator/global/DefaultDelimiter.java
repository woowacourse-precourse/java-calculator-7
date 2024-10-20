package calculator.global;

public enum DefaultDelimiter {

    COMMA(','),
    COLON(':');

    private final char key;

    DefaultDelimiter(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }
}
