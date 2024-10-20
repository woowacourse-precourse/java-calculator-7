package calculator.separator;

import java.util.List;

public class SeparatorCalculator {

    private final List<NumericString> numbers;

    private SeparatorCalculator(List<NumericString> numbers) {
        this.numbers = numbers;
    }

    public static SeparatorCalculator positiveCalculator(String input, Separators separators) {
        List<NumericString> numericStrings = separators.split(input).stream()
                .map(NumericString::positive)
                .toList();

        return new SeparatorCalculator(numericStrings);
    }

    public NumericString sum() {
        return numbers.stream()
                .reduce(NumericString.ZERO, NumericString::add);
    }
}
