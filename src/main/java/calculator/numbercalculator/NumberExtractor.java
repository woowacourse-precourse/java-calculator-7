package calculator.numbercalculator;

import calculator.numbercalculator.delimiter.Delimiter;
import calculator.numbercalculator.delimiter.Delimiters;
import calculator.numbercalculator.number.Numbers;
import java.util.List;

public class NumberExtractor {
    private final Delimiters delimiters = new Delimiters();
    private final CustomDelimiterCalculator customDelimiterCalculator = new CustomDelimiterCalculator();

    public Numbers extractNumbers(String input) {
        if (input.isEmpty()) {
            return Numbers.empty();
        }
        if (customDelimiterCalculator.matches(input)) {
            Delimiter customDelimiter = customDelimiterCalculator.extract(input);
            delimiters.add(customDelimiter);
            input = customDelimiterCalculator.removeCustomDelimiter(input);
        }

        List<String> splitNumbers = delimiters.split(input);
        return Numbers.of(splitNumbers);
    }
}
