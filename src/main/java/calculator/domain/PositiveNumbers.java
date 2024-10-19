package calculator.domain;

import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    private PositiveNumbers(final List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public static PositiveNumbers from(final List<String> numbers) {
        return new PositiveNumbers(convertToPositiveNumbers(numbers));
    }

    private static List<PositiveNumber> convertToPositiveNumbers(final List<String> numbers) {
        return numbers.stream()
                .map(PositiveNumber::from)
                .toList();
    }

    public PositiveNumber sum() {
        return positiveNumbers.stream()
                .reduce(PositiveNumber.zero(), PositiveNumber::add);
    }

}
