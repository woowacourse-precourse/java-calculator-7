package calculator.separator;

import java.util.List;

public class SeparatorCalculator {

    public static NumericString sum(String input, Separators separators) {
        List<String> numericStrings = separators.split(input);

        return numericStrings.stream()
                .map((str) -> NumericString.of(input, 1))
                .reduce(NumericString.ZERO, NumericString::sum);
    }
}
