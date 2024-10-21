package calculator.separator;

public enum FixedSeparator {
    SEPARATOR_NORMAL_1(':'),
    SEPARATOR_NORMAL_2(',');

    private Character separator;

    FixedSeparator(Character separator) {
        this.separator = separator;
    }

    public Character getSeparator() {
        return separator;
    }
}
