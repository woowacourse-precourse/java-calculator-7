package calculator.model;

import calculator.parser.DelimiterParser;
import calculator.validator.InputValidator;

public class CalculatorImpl implements Calculator {

    private final InputValidator validator;
    private final DelimiterParser delimiterParser;

    public CalculatorImpl(InputValidator validator, DelimiterParser delimiterParser) {
        this.validator = validator;
        this.delimiterParser = delimiterParser;
    }

    @Override
    public int calculate(String input) {
        validator.validateEmptyOrNull(input);
        String[] numbers = delimiterParser.parse(input);
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            validator.checkNegativeNumber(num);
            total += num;
        }
        return total;
    }
}
