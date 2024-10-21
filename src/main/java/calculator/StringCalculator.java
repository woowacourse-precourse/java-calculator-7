package calculator;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = DelimiterParser.parse(input);
        String numbers = DelimiterParser.extractNumbers(input);

        int[] parsedNumbers = NumberParser.parse(numbers, delimiter);
        // Validator.validate(parsedNumbers);

        return sum(parsedNumbers);
    }

    private static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
