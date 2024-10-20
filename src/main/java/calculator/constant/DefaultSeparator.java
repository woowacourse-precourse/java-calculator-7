package calculator.constant;

public enum DefaultSeparator {
    COMMA(','),
    COLON(':');

    private final Character separator;

    DefaultSeparator(Character separator) {
        this.separator = separator;
    }

    public Character getSeparator() {
        return separator;
    }
}
