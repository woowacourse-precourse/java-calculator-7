package calculator.sumCalculator.util;

import calculator.common.exception.ExceptionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {

    private final static String REGEXP_DEFAULT_DELIMITER_PATTERN = "[^,;]+(?=[,;]|$)|(?<=^|[,;])[^,;]+";

    public List<Integer> extractNumbers(String expression, boolean hasCustomDelimiter, String customDelimiter) {
        if (hasCustomDelimiter) {
            return findNumbersUsedCustomRegex(expression, customDelimiter);
        }
        return findNumbersUsedDefaultRegex(expression);
    }

    /**
     * 기본 구분자를 사용해서 숫자를 추출한다.
     * @param expression 숫자를 추출할 연산식
     * @return 숫자 리스트
     */
    private List<Integer> findNumbersUsedDefaultRegex(String expression) {
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEXP_DEFAULT_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            try {
                numbers.add(Integer.parseInt(matcher.group()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionCode.INVALID_NUMBER_USED.getMessage());
            }
        }
        return numbers;
    }

    /**
     * 커스텀 구분자를 사용해서 숫자를 추출한다.
     * @param expression 숫자를 추출할 연산식
     * @param delimiter 커스텀 구분자
     * @return 숫자 리스트
     */
    private List<Integer> findNumbersUsedCustomRegex(String expression, String delimiter) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = expression.split(Pattern.quote(delimiter));
        for (String number : parts) {
            try {
                numbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionCode.INVALID_NUMBER_USED.getMessage());
            }
        }
        return numbers;
    }
}
