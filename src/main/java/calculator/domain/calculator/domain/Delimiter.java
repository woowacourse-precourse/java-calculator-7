package calculator.domain.calculator.domain;

import calculator.domain.calculator.util.DelimiterParser;

public class Delimiter {
    private static final String DEFAULT_PATTERN = "[,:]";
    private final String pattern;

    private Delimiter(String pattern) {
        this.pattern = DelimiterParser.parse(pattern);
    }

    public static Delimiter of(final String input) {
        return new Delimiter(input);
    }

    public String getPattern() {
        return this.pattern;
    }
}