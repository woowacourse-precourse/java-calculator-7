package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public String[] parseInput(String input) {

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(Pattern.quote(customDelimiter));
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

}
