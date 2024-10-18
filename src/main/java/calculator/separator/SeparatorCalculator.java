package calculator.separator;

import java.util.List;

public class SeparatorCalculator {

    public static NumericString sum(String input, Separators separators) {
        List<String> numericStrings = separators.split(input);
        validateEmptyNumericStrings(numericStrings);

        return numericStrings.stream()
                .map(NumericString::positive)
                .reduce(NumericString.ZERO, NumericString::add);
    }

    private static void validateEmptyNumericStrings(List<String> numericStrings) {
        if (numericStrings.isEmpty()) {
            throw new IllegalArgumentException("계산할 숫자를 입력하세요");
        }
    }
}
