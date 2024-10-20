package calculator;

import java.util.stream.Stream;

public class StringCalculator {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        return processInput(input);
    }

    private int processInput(String input) {
        DelimiterInfo delimiterInfo = parseDelimiter(input);
        return Stream.of(delimiterInfo.content().split(delimiterInfo.delimiter()))
                .peek(this::validateNumber)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private DelimiterInfo parseDelimiter(String input) {
        if (!hasCustomDelimiter(input)) {
            return new DelimiterInfo(input, DEFAULT_DELIMITERS);
        }
        return parseCustomDelimiter(input);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.length() >= 5 && input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private DelimiterInfo parseCustomDelimiter(String input) {
        int suffixIndex = getSuffixIndex(input);
        String customDelimiter = extractCustomDelimiter(input, suffixIndex);
        validateCustomDelimiter(customDelimiter);
        return createDelimiterInfo(input, suffixIndex, customDelimiter);
    }

    private int getSuffixIndex(String input) {
        int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (suffixIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
        return suffixIndex;
    }

    private String extractCustomDelimiter(String input, int suffixIndex) {
        return input.substring(2, suffixIndex);
    }

    private void validateCustomDelimiter(String delimiter) {
        if (delimiter.length() != 1 || Character.isDigit(delimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 한 글자여야 합니다.");
        }
    }

    private DelimiterInfo createDelimiterInfo(String input, int suffixIndex, String customDelimiter) {
        String numberPart = input.substring(suffixIndex + 2);
        String combinedDelimiter = String.format("[%s,:]", customDelimiter);
        return new DelimiterInfo(numberPart, combinedDelimiter);
    }

    private void validateNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다: " + number);
        }
    }

    private record DelimiterInfo(String content, String delimiter) {}
}
