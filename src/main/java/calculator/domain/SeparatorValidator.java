package calculator.domain;

import java.util.regex.Pattern;

public class SeparatorValidator {
    private static final String ERROR_MESSAGE_FOR_SEPARATOR = "구분자를 잘못 입력하셨습니다. 프로그램을 종료합니다.";
    private static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("[-\\d,:]+");

    public static void validate(String[] extractedStrings) {
        for (String string : extractedStrings) {
            if (hasInvalidSeparatorFormat(string)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_FOR_SEPARATOR);
            }
        }
    }

    private static boolean hasInvalidSeparatorFormat(String str) {
        return hasConsecutiveSeparator(str) || hasInvalidSeparator(str);
    }

    private static boolean hasConsecutiveSeparator(String str) {
        return str.isEmpty();
    }

    private static boolean hasInvalidSeparator(String str) {
        return !VALID_NUMBER_PATTERN.matcher(str).matches();
    }
}
