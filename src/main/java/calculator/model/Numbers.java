package calculator.model;

import calculator.constant.ErrorMessage;
import java.util.List;
import java.util.regex.Pattern;

public class Numbers {
    private final static long MIN = 1L;
    private final static long SUM_BASE = 0L;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^0|[1-9]+[0-9]*$");

    private final List<Long> numbers;

    private Numbers(List<Long> numbers) {
        validatePositive(numbers);
        this.numbers = numbers;
    }

    public static Numbers from(List<Long> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers parseNumbers(List<String> stringNumbers) {
        validateNumber(stringNumbers);

        try {
            List<Long> numbers = stringNumbers.stream()
                    .map(Long::parseLong)
                    .toList();

            return new Numbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_RANGE.getMessage());
        }
    }

    private void validatePositive(List<Long> numbers) {
        numbers.stream()
                .filter(number -> number < MIN)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ErrorMessage.NUMBERS_MUST_POSITIVE.getMessage());
                });
    }

    private static void validateNumber(List<String> stringNumbers) {
        if (!stringNumbers.stream().allMatch(
                stringNumber -> NUMBER_PATTERN.matcher(stringNumber).matches()
        )) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_MUST_NUMBER.getMessage());
        }
    }

    Long sum() {
        return numbers.stream()
                .reduce(SUM_BASE, Long::sum);
    }
}