package calculator;

import java.util.List;

import static java.lang.String.format;

public class Calculator {
    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static String CUSTOM_DELIMITER = "";

    public static int calculate(final String input) {
        List<String> parsedNumbers = parseNumbers(input);

        return parsedNumbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static List<String> parseNumbers(final String input) {
        if (hasCustomDelimiter(input)) {
            setCustomDelimiter(input);

            int subStringLength = CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER.length() + CUSTOM_DELIMITER_SUFFIX.length();
            String newInput = input.substring(subStringLength);

            return List.of(newInput.split(format("[%s|%s|%s]", FIRST_DELIMITER, SECOND_DELIMITER, CUSTOM_DELIMITER)));
        }
        return List.of(input.split(format("[%s|%s]", FIRST_DELIMITER, SECOND_DELIMITER)));
    }

    private static void setCustomDelimiter(final String input) {
        int prefixIndex = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        CUSTOM_DELIMITER = input.substring(prefixIndex + CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);

        if(isDuplicatedDelimiter()) throw new IllegalArgumentException("[ERROR] 중복된 구분자 지정");
    }

    private static boolean isDuplicatedDelimiter() {
        return (CUSTOM_DELIMITER.equals(FIRST_DELIMITER)
            || CUSTOM_DELIMITER.equals(SECOND_DELIMITER)
            || CUSTOM_DELIMITER.equals(CUSTOM_DELIMITER_PREFIX)
            || CUSTOM_DELIMITER.equals(CUSTOM_DELIMITER_SUFFIX));
    }

    private static boolean hasCustomDelimiter(final String input) {
        if(!input.startsWith(CUSTOM_DELIMITER_PREFIX)) return false;
        return input.contains(CUSTOM_DELIMITER_SUFFIX);
    }
}