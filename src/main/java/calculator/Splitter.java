package calculator;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.*)\\\\n(.*)";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CONTENT_GROUP = 2;


    public static List<String> splitByDelimiter(String userInput) {
        String delimiter = DEFAULT_DELIMITER_REGEX;
        String content = userInput;

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            delimiter = Pattern.quote(customDelimiter);
            content = matcher.group(CONTENT_GROUP);
        }

        return Arrays.asList(content.split(delimiter));
    }
}
