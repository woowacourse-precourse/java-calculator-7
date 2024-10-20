package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITER = ",";

    public long calculate(String input){
        if (isEmpty(input)) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String[] segments = splitToDelimiterPatternAndNumbers(input);
            String delimiterPattern = segments[0];
            input = segments[1];

            String customDelimiter = extractCustomDelimiter(delimiterPattern);
            delimiters.add(customDelimiter);
        }

        input = normalizeDelimiters(input, delimiters);
        List<Long> numbers = splitToNumbers(input);

        return 0;
    }

    private boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    private String[] splitToDelimiterPatternAndNumbers(String input) {
        if (!input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자 종료 위치를 알 수 없습니다.");
        }
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String[] delimiterPatternAndNumbers = new String[2];
        delimiterPatternAndNumbers[0] = input.substring(0, delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length());
        delimiterPatternAndNumbers[1] = input.substring(delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length());

        return delimiterPatternAndNumbers;
    }

    private String extractCustomDelimiter(String delimiterPattern) {
        int startIdx = CUSTOM_DELIMITER_PREFIX.length();
        int endIdx = delimiterPattern.length() - CUSTOM_DELIMITER_SUFFIX.length();
        String delimiter = delimiterPattern.substring(startIdx, endIdx);

        if (delimiter.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다.");
        }
        return delimiter;
    }

    // 구분자를 하나로 통일
    private String normalizeDelimiters(String input, List<String> delimiters) {
        for (String delimiter : delimiters) {
            input = input.replace(delimiter, DEFAULT_DELIMITER);
        }
        return input;
    }

    private List<Long> splitToNumbers(String input) {
        String[] segments = input.split(DEFAULT_DELIMITER);
        List<Long> numbers = new ArrayList<>();
        for (String segment : segments) {
            long number = parseToNumber(segment);
            numbers.add(number);
        }

        return numbers;
    }

    private long parseToNumber(String number) {
        if (!Pattern.matches("^[1-9]\\d*|$", number)) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
        if (number.isBlank()) {
            return 0;
        }

        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("범위를 초과하는 입력입니다.");
        }
    }
}
