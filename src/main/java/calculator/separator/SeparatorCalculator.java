package calculator.separator;

import java.util.List;

public class SeparatorCalculator {

    public static NumericString sum(String input, Separators separators) {
        List<String> numericStrings = separators.split(input);
        validateConsecutiveSeparator(numericStrings);

        return numericStrings.stream()
                .map(NumericString::positive)
                .reduce(NumericString.ZERO, NumericString::add);
    }

    private static void validateConsecutiveSeparator(List<String> numericStrings) {
        if (numericStrings.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("구분자는 연속해서 올 수 없습니다.");
        }
    }
}
