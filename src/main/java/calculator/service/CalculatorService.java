package calculator.service;

public class CalculatorService {
    private static int sumNumbers(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            sum += myParseInt(number);
        }
        return sum;
    }

    private static int myParseInt(String number) {
        int result = Integer.parseInt(number);
        return result;
    }
}