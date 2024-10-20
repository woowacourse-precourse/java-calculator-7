package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParserUtil {
    private static final String BASIC_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\\\n(.*)";
    private static final int CUSTOM_DELIMITER_GROUP_NUMBER = 1;
    private static final int EXPRESSION_GROUP_NUMBER = 2;
    private static final int NO_LIMIT_SPLIT_NUMBER = -1;

    public String[] seperator(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP_NUMBER);
            return matcher.group(EXPRESSION_GROUP_NUMBER).split("\\" + customDelimiter, NO_LIMIT_SPLIT_NUMBER);
        }

        return input.split(BASIC_DELIMITERS);
    }
}
