package calculator.model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = "[,|:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEW_LINE_LITERAL = "\\n";
    private static final int EMPTY_RESULT = 0;

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_RESULT;
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return sum(parseNumbersWithCustomDelimiter(input));
        }

        return sum(parseNumbers(input));
    }

    private int[] parseNumbers(String input) {
        String[] tokens = input.split(DEFAULT_DELIMITERS);
        return convertToNumbers(tokens);
    }

    private int[] parseNumbersWithCustomDelimiter(String input) {
        // "//;\n "\n"을 기준으로 두 부분으로 나누기
        int delimiterIndex = input.indexOf(NEW_LINE_LITERAL);

        // 커스텀 구분자는 "//" 이후부터 "\n" 이전까지의 문자열
        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
        String numbersPart = input.substring(delimiterIndex + NEW_LINE_LITERAL.length());

        // 커스텀 구분자를 사용하여 숫자 부분을 분리
        String[] tokens = numbersPart.split(Pattern.quote(customDelimiter));
        return convertToNumbers(tokens);
    }

    private int[] convertToNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
