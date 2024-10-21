package calculator;

import java.util.regex.Pattern;

public class StringSplitter {
    private final DelimiterValidator delimiterValidator;

    StringSplitter(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public String[] split(String input) {
        String defaultDelimiter = delimiterValidator.getDefaultDelimiters();
        String customDelimiter = delimiterValidator.getCustomDelimiter();

        if (customDelimiter.isEmpty()) {
            return input.split("[" + defaultDelimiter + "]", -1);
        }

        customDelimiter = Pattern.quote(customDelimiter);
        String numbersSection = input.substring(delimiterValidator.getDelimiterCommandLength());
        return numbersSection.split("[" + defaultDelimiter + customDelimiter + "]", -1);
    }
}
