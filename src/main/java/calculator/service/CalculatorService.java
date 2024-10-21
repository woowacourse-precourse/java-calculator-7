package calculator.service;

public class CalculatorService {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            return customSum(input);
        }
        String[] numbers = splitString(input);
        return calculateSum(numbers);
    }

    private int customSum(String input) {
        String delimiter = input.substring(2, input.indexOf("\n"));
        String numbersPart = input.substring(input.indexOf("\n") + 1);
        String[] numbers = numbersPart.split(delimiter);
        return calculateSum(numbers);
    }

    private String[] splitString(String input) {
        return input.split(",|:");
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed.");
            }
            sum += num;
        }
        return sum;
    }
}
