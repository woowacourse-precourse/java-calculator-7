package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    public static String[] parse(String input) {
        String delimiter = ",|:";
        String customDelimiter = "//(.*)\\\\n(.*)";
        Pattern pattern = Pattern.compile(customDelimiter);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }
        return input.split(delimiter);
    }
}