package calculator;

import calculator.domain.Calculator;
import calculator.util.DelimiterExtractor;
import calculator.util.NumberExtractor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private final NumberExtractor numberExtractor;
    private final DelimiterExtractor delimiterExtractor;

    public CalculatorService(NumberExtractor numberExtractor, DelimiterExtractor delimiterExtractor) {
        this.numberExtractor = numberExtractor;
        this.delimiterExtractor = delimiterExtractor;
    }

    public int sum(String input) {
        boolean isCustomDelimiter = input.startsWith("//");
        if (isCustomDelimiter) {
            return sumWithCustomDelimiter(input);
        } else {
            return sumWithDefaultDelimiter(input);
        }
    }

    /**
     * 기본 구분자를 사용해서 더한다.
     * @param input 사용자 입력 문자열
     * @return 더한 결과
     */
    private int sumWithDefaultDelimiter(String input) {
        delimiterExtractor.validateDefaultDelimiter(input);
        List<Integer> numbers = numberExtractor.extractNumbers(input, false, "");
        return sumNumbers(Calculator.of(numbers));
    }

    /**
     * 커스텀 구분자를 사용해서 더한다.
     * @param input 사용자 입력 문자열
     * @return 더한 결과
     */
    private int sumWithCustomDelimiter(String input) {
        String expression = extractExpression(input);
        String customDelimiter = delimiterExtractor.extractCustomDelimiter(input);
        List<Integer> numbers = numberExtractor.extractNumbers(expression, true, customDelimiter);
        return sumNumbers(Calculator.of(numbers));
    }

    /**
     * 커스텀 구분자 사용할 경우 연산식을 추출한다.
     * @param input 사용자 입력 문자열
     * @return 연산식
     */
    private String extractExpression(String input) {
        Pattern pattern = Pattern.compile("(?<=\\n).*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    /**
     * 추출한 숫자로 덧셈 연산한다.
     * @param calculator 계산기
     * @return 더한 결과
     */
    private Integer sumNumbers(Calculator calculator) {
        return calculator.sum();
    }
}
