package calculator;

public class Calculator {
    public int add(String input) {
        InputValidator.validateInput(input);

        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = StringParser.parseNumbers(input);
        return calculateSum(numbers);
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            InputValidator.validateNumber(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
