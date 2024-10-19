package calculator;

public class StringDivider {
    private static final String DEFAULT_SEPARATOR = ":|,";
    private final String separator;

    public StringDivider() {
        this.separator = DEFAULT_SEPARATOR;
    }

    public StringDivider(String customSeparator) {
        this.separator = DEFAULT_SEPARATOR + "|" + customSeparator;
    }

    public String[] divideStringBy(String givenString) {
        return givenString.split(this.separator);
    }
}
