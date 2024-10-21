package calculator;

import java.util.Arrays;

/**
 * 문자열을 숫자 배열로 변환하여 계산을 수행하는 클래스.
 *
 * <p>문자열로 초기화되며 생성된다.
 * 문자열의 배열 변환은 {@link DelimiterParser#parseInput(String)}
 * 을 통해 이루어진다.</p>
 */
public class StringCalculator {
    private final DelimiterParser delimiterParser = new DelimiterParser();
    private int[] expression;

    public StringCalculator(String input) {
        preprocessOnInput(input);
    }

    private void preprocessOnInput(String input) {
        String[] stringExpression = makeStringToExpression(input);
        expression = stringToIntegerArray(stringExpression);
    }

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