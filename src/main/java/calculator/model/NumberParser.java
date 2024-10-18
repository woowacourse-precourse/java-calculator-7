package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final List<Number> numbers;
    private final DelimiterParser delimiterParser;

    protected NumberParser(final String input) {
        delimiterParser = new DelimiterParser(input);
        numbers = parseNumber(input);
    }

    private List<Number> parseNumber(final String input) {
        final String target = extractTargetString(input);
        final String regex = String.join("|", delimiterParser.getDelimiters());
        final List<Number> numbers = new ArrayList<>();
        for (String num : target.split(regex)) {
            numbers.add(new Number(num));
        }
        return numbers;
    }

    private String extractTargetString(final String input) {
        return input.substring(delimiterParser.getDelimiterEnd() + 2);
    }

    protected List<Number> getNumbers() {
        return numbers;
    }
}
