package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] numbers = parseNumbers(input);
        return sum(numbers);
    }
    String[] parseNumbers(String input) {
        String delimiter = ",|:";
        return input.split(delimiter);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            validatePositive(num);
            total += num;
        }
        return total;
    }
    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + number);
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
        }
    }

}
