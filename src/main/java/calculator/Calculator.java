package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int add(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }
        return sum(split(text));
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(DEFAULT_DELIMITER + "|" + customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
