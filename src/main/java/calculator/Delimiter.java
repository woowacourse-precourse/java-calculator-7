package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\\\\n(.*)");

    private String delimiter;
    private String[] numbers;

    public Delimiter() {
    }

    public void parseInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1).trim();
            numbers = matcher.group(2).split(delimiter);
        } else {
            delimiter = DEFAULT_DELIMITERS;
            numbers = input.split(delimiter);
        }
    }

    public String[] getNumbers() {
        return numbers;
    }
}
