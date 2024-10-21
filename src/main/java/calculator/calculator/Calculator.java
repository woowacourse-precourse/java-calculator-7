package calculator.calculator;

public class Calculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitNumbers(input);
        return sum(numbers);
    }

    private String[] splitNumbers(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        return input.split(delimiter);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parsedNumber = parseNumber(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed.");
            }
            sum += parsedNumber;
        }
        return sum;
    }

    private int parseNumber(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}