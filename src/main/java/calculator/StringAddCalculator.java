package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator implements StringCalculator {
    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int CUSTOM_DELIMITER_ORDER = 1;
    private static final int ARITHMETIC_EXPRESSION_ORDER = 2;

    @Override
    public int add(String input) {
        if (input == null || input.isBlank()) {
            return DEFAULT_VALUE;
        }
        DelimiterAndNumber delimiterAndNumber = extractCustomDelimiterAndNumbers(input);
        List<Integer> numbers = splitNumbers(delimiterAndNumber);
        validateNumbers(numbers);
        return sum(numbers);
    }

    private DelimiterAndNumber extractCustomDelimiterAndNumbers(String input) {
        String delimiters = DEFAULT_DELIMITER;
        String numbersString = input;
        Matcher matcher = CustomRegexMatcher.getMatcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_ORDER);
            numbersString = matcher.group(ARITHMETIC_EXPRESSION_ORDER);
            // 주의!!! "|"는 기본 구분자에 커스텀 구분자를 추가하려면 반드시 더해주어야 함.
            delimiters += "|" + Pattern.quote(customDelimiter);
        }
        return new DelimiterAndNumber(delimiters, numbersString);
    }

    private List<Integer> splitNumbers(DelimiterAndNumber delimiterAndNumber) {
        String delimiters = delimiterAndNumber.delimiters();
        String numbersString = delimiterAndNumber.numbersString();
        String[] splitNumbers = numbersString.split(delimiters);
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(
                        String.format("(%s)는 음수입니다. 입력하는 숫자들은 반드시 양수 혹은 0이어야 합니다.", number)
                );
            }
        }
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
