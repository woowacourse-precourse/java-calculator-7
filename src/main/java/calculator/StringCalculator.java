package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final DelimiterParser delimiterParser = new DelimiterParser();

    private int[] expression;

    /**
     * 계산을 위한 문자열을 받아들인다.
     *
     * <p>{@link DelimiterParser#parseInput(String)}을 이용하여 문자열을 분리하고
     * {@code int[]}로 변환하여 저장한다.</p>
     * @param input 계산을 원하는 문자열.
     */
    public void getInput(String input) {
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