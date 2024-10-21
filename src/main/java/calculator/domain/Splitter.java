package calculator.domain;

import calculator.utils.Delimiter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Splitter {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private final Validator validator;
    private String delimiter;

    public Splitter(Validator validator) {
        this.validator = validator;
        this.delimiter = DEFAULT_DELIMITERS;
    }

    public List<String> splitInputByDelimiter(String input) {
        String targetString = extractDelimiter(input);
        return Arrays.asList(targetString.split(delimiter));
    }

    private String extractDelimiter(String input) {
        validator.validateInput(input);

        Matcher matcher = Delimiter.CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.matches()) {
            setDelimiter(matcher.group(1));
            return matcher.group(2);
        }
        validator.validateCustomDelimiter(input);
        return input;
    }

    private void setDelimiter(String customDelimiter) {
        this.delimiter = DEFAULT_DELIMITERS + "|" + customDelimiter;
    }
}
