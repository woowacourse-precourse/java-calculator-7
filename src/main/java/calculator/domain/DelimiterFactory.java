package calculator.domain;

public class DelimiterFactory {

    private DelimiterFactory() {}

    public static Delimiter create(final String input) {
        Delimiter defaultDelimiter = new DefaultDelimiter(input);
        Delimiter customDelimiter = new CustomDelimiter(input);

        if (defaultDelimiter.matches()) {
            return defaultDelimiter;
        }
        if (customDelimiter.matches()) {
            return customDelimiter;
        }
        throw new IllegalArgumentException();
    }

}
