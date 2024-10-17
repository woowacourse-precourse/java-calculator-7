package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtil {
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.*?)\\n";

    private CalculatorUtil() {};

    public static List<String> extractDelimiter(String inputValue) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(inputValue);
        List<String> delimiters = new ArrayList<>();

        if (inputValue.contains(",")) delimiters.add(",");

        if (inputValue.contains(":")) delimiters.add(":");

        if (matcher.find()) {
            String[] customDelimiters = matcher.group(1).split("\\|");

            for (String delimiter : customDelimiters) {
                delimiters.add(delimiter.trim());
            }
        }

        return delimiters;
    }
}
