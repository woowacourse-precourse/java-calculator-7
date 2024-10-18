package calculator.model;

import static calculator.validate.NumberValidator.validateNumber;

public class Calculator {

    private static int result;
    private final InputParser parser = new InputParser();

    public void calculate(String input) {
        String[] numbers = parser.parseInput(input);
        calculateSum(numbers);
    }

    private void calculateSum(String[] numbers) {
        for (String number : numbers) {
            validateNumber(number);
            result += Integer.parseInt(number);
        }
    }

    public int getResult() {
        return result;
    }
}
