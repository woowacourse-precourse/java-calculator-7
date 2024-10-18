package calculator;

import calculator.util.IntegerParser;
import calculator.util.IntegerValidator;
import delimiter.Delimiter;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final Delimiter delimiter;
    private final IntegerParser integerParser;
    private final IntegerValidator integerValidator;
    private final Calculator calculator;

    public StringCalculator() {
        this.delimiter = new Delimiter();
        this.integerParser = new IntegerParser();
        this.integerValidator = new IntegerValidator();
        this.calculator = new Calculator();
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = delimiter.split(input);
        List<Integer> validNumbers = new ArrayList<>();

        for (String number : numbers) {
            int parsedNumber = integerParser.parse(number.trim());
            integerValidator.validate(parsedNumber);
            validNumbers.add(parsedNumber);
        }

        return calculator.sum(validNumbers);
    }
}

