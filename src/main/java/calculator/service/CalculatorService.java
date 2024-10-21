package calculator.service;

import calculator.domain.DelimiterExtractor;
import calculator.service.command.Command;

public class CalculatorService {

    private final DelimiterExtractor extractor;
    private Command calculator;

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
