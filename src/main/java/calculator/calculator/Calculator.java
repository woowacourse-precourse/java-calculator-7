package calculator.calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;
import calculator.delimiter.DelimiterUtils;
import java.util.List;
import java.util.Objects;

public class Calculator {

    private final DelimiterFactory delimiterFactory = new DelimiterFactory();

    public int calculate(String input) {
        validateInput(input);
        String removedSpaces = DelimiterUtils.removeSpaces(input);

        Delimiter delimiter = delimiterFactory.getDelimiter(removedSpaces);
        List<Integer> extractNumbers = delimiter.extractNumbers(removedSpaces);
        validateNumbers(extractNumbers);

        return extractNumbers
                .stream()
                .reduce(0, Integer::sum);
    }

    private void validateInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("null 값은 허용되지 않는다.");
        }
    }

    private void validateNumbers(List<Integer> inputNumbers) {
        if (inputNumbers.stream().anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException("음수는 허용되지 않는다");
        }
    }
}
