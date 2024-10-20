package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String BASIC_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int NUMBER_GROUP = 2;

    public String[] split(String input) {
        input = input.replace("\\n", "\n");
        Matcher matcher = getCustomDelimiterMatcher(input);
        if (matcher != null) {
            return handleCustomDelimiter(matcher);
        }
        return splitWithBasicDelimiter(input);
    }

    private Matcher getCustomDelimiterMatcher(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher;
        }
        return null;
    }


    private String[] handleCustomDelimiter(Matcher matcher) {
        String customDelimiter = Pattern.quote(matcher.group(CUSTOM_DELIMITER_GROUP));
        String numbers = matcher.group(NUMBER_GROUP);
        return splitWithCustomDelimiter(numbers, customDelimiter);
    }

    private String[] splitWithCustomDelimiter(String input, String customDelimiter) {
        return input.split(customDelimiter);
    }

    private String[] splitWithBasicDelimiter(String input) {
        return input.split(BASIC_DELIMITER);
    }
}
