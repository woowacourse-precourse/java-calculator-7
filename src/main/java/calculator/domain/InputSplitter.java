package calculator.domain;

import calculator.enums.RegexPattern;
import calculator.exception.InvalidDelimiterException;

import java.util.regex.Pattern;

public class InputSplitter {
    private static final String COMMA_COLON_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int START_INDEX_EXCEPT_REGEX = 5;

    public String[] splitByDelimiter(String input) {
        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (RegexPattern.CUSTOM_DELIMITER.find(input)) {
            String customDelimiter = escapeMetacharacter(getCustomDelimiter(input));
            input = input.substring(START_INDEX_EXCEPT_REGEX);
            return input.split(customDelimiter);
        }
        return validateCommaAndColonDelimiter(input);
    }

    private String getCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }

    private String[] validateCommaAndColonDelimiter(String input) {
        if (!RegexPattern.ONLY_COMMA_COLON_DELIMITER.matches(input)) {
            throw new InvalidDelimiterException();
        }
        return input.split(COMMA_COLON_DELIMITER);
    }

    private String escapeMetacharacter(String delimiter) {
        return Pattern.quote(delimiter);
    }
}
