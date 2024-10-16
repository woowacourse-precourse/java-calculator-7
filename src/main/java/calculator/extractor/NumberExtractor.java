package calculator.extractor;

import calculator.delimiter.Delimiter;
import calculator.delimiter.Delimiters;
import calculator.number.Numbers;
import java.util.List;

public class NumberExtractor {
    private final Delimiters delimiters = new Delimiters();
    private final CustomDelimiterCalculator customDelimiterCalculator = new CustomDelimiterCalculator();

    public Numbers extractNumbers(String input) {
        if (customDelimiterCalculator.matches(input)) {
            Delimiter customDelimiter = customDelimiterCalculator.extract(input);
            delimiters.add(customDelimiter);
            input = customDelimiterCalculator.removeCustomDelimiter(input);
        }

        List<String> splitNumbers = delimiters.split(input);
        return Numbers.of(splitNumbers);
    }
}
