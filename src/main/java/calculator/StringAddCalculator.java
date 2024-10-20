package calculator;

import java.util.List;

public class StringAddCalculator {

    private final DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
    private final NumberExtractor numberExtractor = new NumberExtractor();
    private int result;

    public int calculate(String inputString) {
        Input input = new Input(inputString);
        if (input.isEmpty()) {
            return this.result;
        }
        DelimiterAndNumber delimiterAndNumber = delimiterExtractor.extract(input);
        List<Integer> numbers = numberExtractor.extractNumbers(delimiterAndNumber);
        InputValidator.validateNumbers(numbers);
        return numbers.stream()
                .reduce(result, Integer::sum);
    }
}
