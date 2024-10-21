package calculator.domain;

import calculator.utils.Delimiter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private final Validator validator;

    public Splitter(Validator validator) {
        this.validator = validator;
    }

    public String extractDelimiter(String input) {
        validator.validateCustomDelimiterPattern(input);
        Matcher matcher = Delimiter.CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            return DEFAULT_DELIMITERS + "|" + customDelimiter;
        }
        return DEFAULT_DELIMITERS;
    }
}
