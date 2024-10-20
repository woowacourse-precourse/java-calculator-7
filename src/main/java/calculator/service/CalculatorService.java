package calculator.service;

import calculator.command.Command;
import calculator.domain.DelimiterExtractor;

public class CalculatorService {

    private Command calculator;
    private final DelimiterExtractor extractor;

    public CalculatorService(DelimiterExtractor extractor) {
        this.extractor = extractor;
    }

    public void setCommand(Command calculator) {
        this.calculator = calculator;
    }

    public String calculate(final String input) {
        if (isEmpty(input)) {
            return "0";
        }

        String[] numbers = split(input);
        return calculator.execute(numbers);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String[] split(String input) {
        String delimiterRegex = extractor.generateDelimiterRegex(input);
        String expression = extractor.getExpression();
        return expression.split(delimiterRegex);
    }
}
