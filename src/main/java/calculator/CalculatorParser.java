package calculator;

import java.util.Arrays;
import java.util.List;

public class CalculatorParser {
    public static final String DEFAULT_DELIMITER = ",:";

    public static List<Integer> parse(String text) {
        String delimiter = DEFAULT_DELIMITER;
        String customDelimiter = extractCustomDelimiter(text);

        if (customDelimiter != null) {
            delimiter += customDelimiter;
            text = text.substring(customDelimiter.length() + 3);
        }
        String regex = "[" + delimiter + "]";

        return Arrays.stream(text.split(regex)).map(Integer::valueOf).toList();
    }

    public static String extractCustomDelimiter(String text) {
        String[] sep = text.split("\n");

        if (sep.length == 1) {
            return null;
        }

        return sep[0].substring(2);
    }
}
