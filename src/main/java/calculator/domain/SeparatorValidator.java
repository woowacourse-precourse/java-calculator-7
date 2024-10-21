package calculator.domain;

import java.util.List;
import java.util.regex.Pattern;

public class SeparatorValidator {
    private static final String ERROR_MESSAGE_FOR_WRONG_CUSTOM_SEPARATOR_FORMAT = "커스텀 구분자 입력 형식이 올바르지 않습니다. 프로그램을 종료합니다.";
    private static final String ERROR_MESSAGE_FOR_SEPARATOR = "구분자를 잘못 입력하셨습니다. 프로그램을 종료합니다.";
    private static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("[-\\d,:]+");

    public static void validateCustomSeparatorFormat(String input, String customStartWord, String customEndWord) {
        if (hasWrongCustomSeparatorFormat(input, customStartWord, customEndWord)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_WRONG_CUSTOM_SEPARATOR_FORMAT);
        }
    }

    public static void validateSeparator(List<String> extractedStrings) {
        for (String str : extractedStrings) {
            if (hasInvalidSeparatorFormat(str)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_FOR_SEPARATOR);
            }
        }
    }

    private static boolean hasWrongCustomSeparatorFormat(String input, String customStartWord, String customEndWord) {
        return (input.startsWith(customStartWord) && !input.contains(customEndWord))
                || (!input.startsWith(customStartWord) && input.contains(customEndWord));
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
