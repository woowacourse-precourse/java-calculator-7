package calculator.model.number;

import static calculator.model.delimiter.CustomDelimiter.CUSTOM_DELIMITER_SUFFIX;

import calculator.model.delimiter.CustomDelimiter;
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
        final String regex = String.join("|", delimiter.getDelimiters());
        final List<Number> numbers = new ArrayList<>();
        Arrays.stream(extractTargetString(input).split(regex))
                .filter(num -> !num.isEmpty())
                .forEach(num -> numbers.add(new Number(num)));
        return numbers;
    }

    private String extractTargetString(final String input) {
        if (delimiter instanceof CustomDelimiter) {
            return input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length());
        }
        return input;
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
