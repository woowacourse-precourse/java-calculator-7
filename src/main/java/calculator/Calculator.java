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
        if (input.isEmpty()) throw new IllegalArgumentException("[ERROR] 입력이 비어 있습니다. 값을 입력해 주세요.");

        List<String> parsedNumbers = parseNumbers(input);

        return parsedNumbers.stream()
                .mapToInt(num -> {
                    if (isInvalidInput(num)) throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");

                    return Integer.parseInt(num);
                })
                .sum();
    }

    private static List<String> parseNumbers(final String input) {
        if (!isEndWithDigit(input)) throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");

        if (hasCustomDelimiter(input)) {
            setCustomDelimiter(input);

            int subStringLength = CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER.length() + CUSTOM_DELIMITER_SUFFIX.length();
            String newInput = input.substring(subStringLength);

            return List.of(newInput.split(format("%s|%s|%s", FIRST_DELIMITER, SECOND_DELIMITER, CUSTOM_DELIMITER)));
        }
        return List.of(input.split(format("%s|%s", FIRST_DELIMITER, SECOND_DELIMITER)));
    }

    private static void setCustomDelimiter(final String input) {
        int prefixIndex = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        CUSTOM_DELIMITER = input.substring(prefixIndex + CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);

        if(isDuplicatedDelimiter()) throw new IllegalArgumentException("[ERROR] 중복된 구분자 지정입니다.");
        if(isContainedDigit()) throw new IllegalArgumentException("[ERROR] 숫자를 포함한 구분자는 지정할 수 없습니다.");
    }

    private static boolean isEndWithDigit(final String input) {
        char lastChar = input.charAt(input.length() - 1);

        return Character.isDigit(lastChar);
    }

    private static boolean isInvalidInput(final String str) {
        return !str.matches("(\\d)+");
    }

    private static boolean isContainedDigit() {
        return CUSTOM_DELIMITER.matches(".*\\d.*");
    }

    private static boolean isDuplicatedDelimiter() {
        return (CUSTOM_DELIMITER.contains(FIRST_DELIMITER)
            || CUSTOM_DELIMITER.contains(SECOND_DELIMITER)
            || CUSTOM_DELIMITER.contains(CUSTOM_DELIMITER_PREFIX)
            || CUSTOM_DELIMITER.contains(CUSTOM_DELIMITER_SUFFIX));
    }

    private static boolean hasCustomDelimiter(final String input) {
        if(!input.startsWith(CUSTOM_DELIMITER_PREFIX)) return false;
        return input.contains(CUSTOM_DELIMITER_SUFFIX);
    }
}