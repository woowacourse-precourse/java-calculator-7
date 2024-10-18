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
        if (input.isEmpty()) return 0;

        List<String> parsedNumbers = parseNumbers(input);

        return parsedNumbers.stream()
                .mapToInt(num -> {
                    if(num.isEmpty()) return 0;

                    if(isContainedLetter(num)) throw new IllegalArgumentException("[ERROR] 지정되지 않은 구분자입니다.");

                    return Integer.parseInt(num);
                })
                .sum();
    }

    private static List<String> parseNumbers(final String input) {
        if (hasCustomDelimiter(input)) {
            setCustomDelimiter(input);

            int subStringLength = CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER.length() + CUSTOM_DELIMITER_SUFFIX.length();

            if(CUSTOM_DELIMITER.equals("\\\\")) subStringLength -= 1;

            String newInput = input.substring(subStringLength);

            return List.of(newInput.split(format("%s|%s|%s", FIRST_DELIMITER, SECOND_DELIMITER, CUSTOM_DELIMITER)));
        }
        return List.of(input.split(format("%s|%s", FIRST_DELIMITER, SECOND_DELIMITER)));
    }

    private static void setCustomDelimiter(final String input) {
        int prefixIndex = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        CUSTOM_DELIMITER = input.substring(prefixIndex + CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);

        if(CUSTOM_DELIMITER.equals("\\")) CUSTOM_DELIMITER += "\\";

        if(isContainedDigit()) throw new IllegalArgumentException("[ERROR] 숫자를 포함한 구분자는 지정할 수 없습니다.");
    }

    private static boolean isContainedLetter(final String str) {
        for(char c : str.toCharArray()) {
            if (Character.isLetter(c)) return true;
        }
        return false;
    }

    private static boolean isContainedDigit() {
        return CUSTOM_DELIMITER.matches(".*\\d.*");
    }

    private static boolean hasCustomDelimiter(final String input) {
        if(!input.startsWith(CUSTOM_DELIMITER_PREFIX)) return false;
        return input.contains(CUSTOM_DELIMITER_SUFFIX);
    }
}