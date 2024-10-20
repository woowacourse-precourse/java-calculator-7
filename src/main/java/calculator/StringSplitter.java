package calculator;

import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMITERS = ",:";
    private final DelimiterValidator delimiterValidator;

    StringSplitter(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public String[] split(String input) {
        String customDelimiter = delimiterValidator.getCustomDelimiter(input);
        customDelimiter = Pattern.quote(customDelimiter);

        return input.split("[" + DEFAULT_DELIMITERS + customDelimiter + "]", -1);
    }
}
