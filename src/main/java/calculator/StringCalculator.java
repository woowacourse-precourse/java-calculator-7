package calculator;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(DEFAULT_DELIMITERS);
        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}