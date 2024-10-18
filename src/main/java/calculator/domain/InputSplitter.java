package calculator.domain;

import calculator.exception.InvalidDelimiterException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
    private static final String REGEX_CUSTOM_DELIMITER = "^//(.)\\\\n";
    private static final String REGEX_COMMA_COLON = "^[0-9]+([,:][0-9]+)*$";
    private static final String COMMA_COLON_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int START_INDEX_EXCEPT_REGEX = 5;

    public String[] splitByDelimiter(String input) {
        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (containsCustomDelimiter(input)) {
            String customDelimiter = escapeMetacharacter(getCustomDelimiter(input));
            input = input.substring(START_INDEX_EXCEPT_REGEX);
            return input.split(customDelimiter);
        }
        return validateCommaAndColonDelimiter(input);
    }

    private boolean containsCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(REGEX_CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private String getCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }

    private String[] validateCommaAndColonDelimiter(String input) {
        if (!input.matches(REGEX_COMMA_COLON)) {
            throw new InvalidDelimiterException();
        }
        return input.split(COMMA_COLON_DELIMITER);
    }

    private String escapeMetacharacter(String delimiter) {
        return Pattern.quote(delimiter);
    }
}
