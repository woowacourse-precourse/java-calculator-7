package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDelimiter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static String[] parse(String input) {
        if (isEmptyInput(input)) {
            return new String[]{"0"};
        }

        if (hasCustomDelimiter(input)) {
            return splitWithCustomDelimiter(input);
        }

        return splitWithDefaultDelimiter(input);
    }

    // 입력이 비어 있는지 확인
    private static boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    // 커스텀 구분자가 있는지 확인
    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    // 커스텀 구분자로 분리하는 메서드
    private static String[] splitWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String customDelimiter = Pattern.quote(matcher.group(1));
        String numbersPart = matcher.group(2);
        return numbersPart.split(customDelimiter);
    }

    // 기본 구분자로 분리하는 메서드
    private static String[] splitWithDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}