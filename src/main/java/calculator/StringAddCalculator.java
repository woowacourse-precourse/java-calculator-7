package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

public class StringAddCalculator implements StringCalculator {
    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int CUSTOM_DELIMITER_ORDER = 0;
    private static final int ARITHMETIC_EXPRESSION_ORDER = 1;
    public static final Set<Character> ALLOWED_DELIMITERS = Set.of(';', ',');

    @Override
    public int add(String input) {
        return Optional.ofNullable(input)
                .filter(it -> !it.isBlank())
                .map(this::processInput)
                .orElse(DEFAULT_VALUE);
    }

    private int processInput(String input) {
        if (input.startsWith("//")) {
            return sumWithCustomDelimiter(input);
        } else {
            return sumWithDefaultDelimiter(input);
        }
    }

    private int sumWithCustomDelimiter(String input) {
        DelimiterAndNumber delimiterAndNumber = extractCustomDelimiterAndNumbers(input);
        List<Integer> numbers = splitNumbers(delimiterAndNumber);
        validateNumbers(numbers);
        return sum(numbers);
    }

    private DelimiterAndNumber extractCustomDelimiterAndNumbers(String input) {
        String[] parts = input.split("\\\\n", 2);
        String customDelimiter = parts[CUSTOM_DELIMITER_ORDER];
        String numbersString = parts[ARITHMETIC_EXPRESSION_ORDER];
        String delimiters = DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter);
        return new DelimiterAndNumber(delimiters, numbersString);
    }

    private int sumWithDefaultDelimiter(String input) {
        validateDefaultDelimiter(input);
        String[] splitNumbers = input.split(DEFAULT_DELIMITER);
        List<Integer> numbers = Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .toList();
        validateNumbers(numbers);
        return sum(numbers);
    }

    private void validateDefaultDelimiter(String input) {
        List<Character> invalidChars = input.chars()
                .mapToObj(c -> (char) c)
                .filter(this::isInvalidChar)
                .toList();
        if (hasInvalidDelimiter(invalidChars)) {
            throw new IllegalArgumentException(
                    String.format("(%s)에서는 허용되지 않는 구분자가 발견되었습니다. (%s)", input, invalidChars)
            );
        }
    }

    private boolean isInvalidChar(char c) {
        return !(Character.isDigit(c) || ALLOWED_DELIMITERS.contains(c));
    }

    private boolean hasInvalidDelimiter(List<Character> invalidChars) {
        return !invalidChars.isEmpty();
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
        List<Integer> negativeNumbers = numbers.stream()
                .filter(num -> num < 0)
                .toList();
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("음수는 허용되지 않습니다: %s", negativeNumbers)
            );
        }
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
