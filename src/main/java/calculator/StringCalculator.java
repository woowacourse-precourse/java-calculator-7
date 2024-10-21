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
        preprocessMakingExpression(input);
    }
    
    public int doSum() {
        return Arrays.stream(expression).sum();
    }

    private void preprocessMakingExpression(String input) {
        String[] stringExpression = stringDivideByDelimiter(input);
        expression = stringToIntegerArray(stringExpression);
    }

    private String[] stringDivideByDelimiter(String input) {
        DelimiterContentPair parsed = delimiterParser.parseInput(input);
        return makeStringArray(parsed);
    }

    private String[] makeStringArray(DelimiterContentPair parsedInput) {
        String delimiter = parsedInput.getDelimiter();
        String content = parsedInput.getContent();
        return content.split(delimiter);
    }

    private int[] stringToIntegerArray(String[] arr) {
        return Arrays.stream(arr).mapToInt(this::parseInt).toArray();
    }

    private Integer parseInt(String str) {
        try {
            if (str.isEmpty()) { // 입력이 빈 경우 처리
                return 0;
            }

            int num = Integer.parseInt(str);
            if (num <= 0) { // 양수가 아닌 경우
                throw new IllegalArgumentException("Invalid input: not allow negative");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: should be Integer.");
        }
    }
}