package calculator.model.number;

import calculator.model.delimiter.Delimiter;
import calculator.model.delimiter.DelimiterParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberParser {
    private final List<Number> numbers;
    private final Delimiter delimiter;

    public NumberParser(final String input) {
        this.delimiter = DelimiterParser.findDelimiter(input);
        this.numbers = parseNumber(input);
    }

    private List<Number> parseNumber(final String input) {
        final List<Number> numbers = new ArrayList<>();
        final String regex = String.join("|", delimiter.getDelimiters());
        Arrays.stream(extractTargetString(input).split(regex))
                .filter(num -> !num.isEmpty())
                .forEach(num -> numbers.add(new Number(num)));
        return numbers;
    }

    private String extractTargetString(final String input) {
        return input.substring(delimiter.getDelimiterEnd() + 2);
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
