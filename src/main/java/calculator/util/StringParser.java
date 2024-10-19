package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static List<String> parseInput(final String input) {
        String delimiter = DEFAULT_DELIMITER;

        if (input.startsWith("//") && input.contains("\\n")) {
            delimiter += extractCustomDelimiters(input);
        }

        return Arrays.asList(input.substring(input.indexOf("\\n") + 2).split(delimiter));
    }

    private static String extractCustomDelimiters(String input) {
        String customDelimiters = input.substring(2, input.indexOf("\\n"));
        return Arrays.stream(customDelimiters.split(""))
                .map(c -> "\\" + c)
                .collect(Collectors.joining("|"));
    }
}