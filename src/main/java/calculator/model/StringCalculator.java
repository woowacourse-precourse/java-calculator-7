package calculator.model;

import calculator.util.DelimiterParser;
import calculator.util.NumberParser;

import java.util.List;

public class StringCalculator {
    private final DelimiterParser delimiterParser;
    private final NumberParser numberParser;

    public StringCalculator(DelimiterParser delimiterParser, NumberParser numberParser) {
        this.delimiterParser = delimiterParser;
        this.numberParser = numberParser;
    }

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        List<String> delimiters = delimiterParser.parseDelimiter(input);
        String[] tokens = delimiterParser.split(input, delimiters);
        List<Integer> numbers = numberParser.parseNumbers(tokens);
        numberParser.validateNumbers(numbers);

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
