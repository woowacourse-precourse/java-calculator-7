package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final List<String> DEFAULT_DELIMITERS_LIST = Arrays.asList(",", ":");


    public static List<String> parseInput(final String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 공백입니다.");
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbers = input;

        if (isCustomDelimiter(input)) {
            validateCustomDelimiter(input);
            delimiter += "|" + extractCustomDelimiters(input);
            numbers = input.substring(input.indexOf("\\n") + 2);
        }
        validateDelimiters(numbers, delimiter);

        return Arrays.asList(numbers.split(delimiter));
    }

    private static String extractCustomDelimiters(String input) {
        String customDelimiters = input.substring(2, input.indexOf("\\n"));
        return Arrays.stream(customDelimiters.split(""))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    private static boolean isCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    private static void validateCustomDelimiter(String input) {
        String customDelimiters = input.substring(2, input.indexOf("\\n"));

        if (customDelimiters.isBlank()) {
            throw new IllegalArgumentException("커스텀 구분자가 공백입니다.");
        }

        if (DEFAULT_DELIMITERS_LIST.contains(customDelimiters)) {
            throw new IllegalArgumentException("커스텀 구분자는 기본 구분자와 중복될 수 없습니다.");
        }

    }

    private static void validateDelimiters(String numbers, String delimiter) {
        String allowedDelimiters = "[0-9" + delimiter.replace("|", "") + "]+";
        if (!numbers.matches(allowedDelimiters)) {
            throw new IllegalArgumentException("구분자가 잘못 사용되었습니다.");
        }
    }

}