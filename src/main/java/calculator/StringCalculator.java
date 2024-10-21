package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final DelimiterParser delimiterParser = new DelimiterParser();

    private int[] stringToIntegerArray(String[] arr) {
        return Arrays.stream(arr).mapToInt(this::parseInt).toArray();
    }

    private String[] makeStringToExpression(String input) {
        DelimiterContentPair parsed = delimiterParser.parseInput(input);
        return makeStrArray(parsed);
    }

    private String[] makeStrArray(DelimiterContentPair parsedInput) {
        String delimiter = parsedInput.getDelimiter();
        String content = parsedInput.getContent();
        return content.split(delimiter);
    }

    private Integer parseInt(String str) {
        try {
            // 비어 있는 문자열 처리
            if (str.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: should be Integer.");
        }
    }
}