package calculator;

import calculator.util.IntegerParser;
import calculator.util.IntegerValidator;
import delimiter.Delimiter;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final Delimiter delimiter;
    private final IntegerParser parser;
    private final IntegerValidator validator;
    private final Calculator calculator;

    public StringCalculator() {
        this.delimiter = new Delimiter();
        this.parser = new IntegerParser();
        this.validator = new IntegerValidator();
        this.calculator = new Calculator();
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = delimiter.split(input);
        List<Integer> validNumbers = new ArrayList<>();

        for (String number : numbers) {
            int parsedNumber = parser.parse(number.trim());
            validator.validate(parsedNumber);
            validNumbers.add(parsedNumber);
        }

        return calculator.sum(validNumbers);
    }
}

