package calculator.domain;

import calculator.util.parser.NumberParser;

import java.util.Arrays;

import static calculator.util.validator.InputValidator.validate;

public class Calculator {

    private final String input;
    private final NumberParser numberParser;

    public Calculator(String input) {
        validate(input);
        this.input = input;
        this.numberParser = new NumberParser();
    }

    public int sum() {
        String[] numbers = NumberParser.parse(input);
        return add(numbers);
    }

    private int add(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
        return total;
    }
}
