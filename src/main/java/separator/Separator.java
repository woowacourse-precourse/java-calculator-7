package separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static String[] split(String inputString) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher customDelimiterMatcher = Pattern.compile("//(.)\\n(.*)").matcher(inputString);

        if (customDelimiterMatcher.find()) {
            delimiter = Pattern.quote(customDelimiterMatcher.group(1));
            inputString = customDelimiterMatcher.group(2);
        }

        return inputString.split(delimiter);
    }
}
