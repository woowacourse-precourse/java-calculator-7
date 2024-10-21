package calculator.model;

import calculator.strategy.DelimiterStrategy;
import calculator.strategy.DelimiterStrategyFactory;
import calculator.util.InputValidator;
import calculator.util.NumberExtractor;
import calculator.util.NumberSummer;


public class Calculator {
    private final String input;

    public Calculator(String input) {
        this.input = input;
    }

    public int calculate() {
        String validatedInput = InputValidator.validate(input);

        if (isZeroInput(validatedInput)) {
            return 0;
        }

        DelimiterStrategy delimiterStrategy = DelimiterStrategyFactory.getDelimiterStrategy(validatedInput);
        String numberPart = delimiterStrategy.extractNumberPart(validatedInput);
        int[] numbers = NumberExtractor.extract(numberPart, delimiterStrategy.getDelimiters());

        return NumberSummer.sum(numbers);
    }

    private boolean isZeroInput(String input) {
        return input.equals("0");
    }
}