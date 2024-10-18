package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITER = ",:";

    public String extractDelimiter(String input) {
        String delimeter = DEFAULT_DELIMITER;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*?)").matcher(input);
            if (matcher.find()) {
                delimeter = delimeter + matcher.group(1);
            }
        }

        return "[" + delimeter + "]";
    }
}
