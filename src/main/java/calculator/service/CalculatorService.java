package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.domain.Separator;
import calculator.util.ListParser;
import java.util.List;

public class CalculatorService {

    private final Calculator calculator;
    private final DelimiterExtractor delimiterExtractor;
    private final Separator separator;

    public CalculatorService(Calculator calculator,
                             DelimiterExtractor delimiterExtractor,
                             Separator separator) {
        this.calculator = calculator;
        this.delimiterExtractor = delimiterExtractor;
        this.separator = separator;
    }

    public Long calculate(String input) {
        if (input.isEmpty()) {
            return 0L;
        }

        String delimiter = delimiterExtractor.extract(input);
        String formula = separator.separateToFormulaPart(input);

        List<String> elements = separator.separateByDelimiter(formula, delimiter);
        List<Long> numbers = ListParser.parseStringsToLongs(elements);

        return calculator.calculateSum(numbers);
    }
}