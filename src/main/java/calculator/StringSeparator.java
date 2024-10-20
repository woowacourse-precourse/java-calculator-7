package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    public String[] parseNumbers(String input) {
        if (input.startsWith("//")) {
            return parseWithCustomDelimiter(input);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private String[] parseWithCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }

        String delimiter = matcher.group(1);
        String numbers = matcher.group(2);

        String allDelimiter = String.format("%s|%s", DEFAULT_DELIMITER, delimiter);

        return numbers.split(allDelimiter);
    }
}
