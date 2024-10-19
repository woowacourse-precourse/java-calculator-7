package calculator.domain;

import java.util.List;

public class PositiveNumbers {

    private static final String DEFAULT_NUMBER = "0";
    private final List<PositiveNumber> positiveNumbers;

    private PositiveNumbers(final List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public static PositiveNumbers from(final List<String> numbers) {
        return new PositiveNumbers(convertToPositiveNumbers(numbers));
    }

    private static List<PositiveNumber> convertToPositiveNumbers(final List<String> numbers) {
        return numbers.stream()
                .filter(PositiveNumbers::isDefault)
                .map(PositiveNumber::from)
                .toList();
    }

    private static boolean isDefault(final String number) {
        return DEFAULT_NUMBER.equals(number) || number.isEmpty();
    }

}
