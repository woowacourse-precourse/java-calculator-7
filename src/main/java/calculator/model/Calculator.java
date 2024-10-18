package calculator.model;

import static calculator.validate.NumberValidator.validateNumber;

import calculator.parser.InputParser;

public class Calculator {

    private static int result;

    private final InputParser parser = new InputParser();

    public void calculate(String input) {
        String[] numbers = parser.parseInput(input);
        calculateSum(numbers);
    }

    private void calculateSum(String[] numbers) {
        for (String number : numbers) {
            try {
                validateNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
            result += Integer.parseInt(number);
        }
    }

    public int getResult() {
        return result;
    }
}
