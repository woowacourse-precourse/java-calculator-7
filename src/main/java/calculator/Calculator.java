package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

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
}
