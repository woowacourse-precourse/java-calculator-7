package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumberParser {
    private final List<Number> numbers;

    public NumberParser( final DelimiterParser delimiterParser) {
        this.numbers = new ArrayList<>();
        parseNumber(delimiterParser);
    }

    private void parseNumber(final DelimiterParser delimiterParser) {
        final String input = delimiterParser.getInput();
        Set<String> delimiters = delimiterParser.getDelimiters();
        String regex = String.join("|", delimiters);
        String[] splitNumbers = input.split(regex);
        for (String num : splitNumbers) {
            numbers.add(new Number(num));
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
