package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factor {

    private static final String DEFAULT_SEPARATOR = ".|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    public String[] parseNumbers(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{"0"};
        }

        String separator = DEFAULT_SEPARATOR;
        String numbers = input;

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.matches()) {
            separator = Pattern.quote(matcher.group(1));
            numbers = matcher.group(2);
        }
        return numbers.split(separator);
    }

}


