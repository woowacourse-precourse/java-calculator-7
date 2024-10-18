package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {
    public static final String DEFAULT_DELIMITER = ",:";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.*)\n(.*)");

    public static List<Integer> parse(String text) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (matcher.find()) {
            delimiter += matcher.group(1);
            text = matcher.group(2);
        }

        String regex = "[" + delimiter + "]";

        return Arrays.stream(text.split(regex))
                .map(Integer::valueOf)
                .toList();
    }
}
