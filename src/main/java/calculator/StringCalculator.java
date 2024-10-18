package calculator;

public class StringCalculator {
    private final DelimiterParser delimiterParser;

    public StringCalculator() {
        delimiterParser = new DelimiterParser();
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = delimiterParser.splitNumbers(input);
        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            if (num < 0) {
                // 예외 발생
            }
            sum += num;
        }
        return sum;
    }
}
