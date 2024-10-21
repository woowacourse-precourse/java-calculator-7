package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final DelimiterParser delimiterParser;

    public StringCalculator() {
        delimiterParser = new DelimiterParser();
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = delimiterParser.parseNumbers(input);

        return sum(numbers);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .map(n -> {
                    validateNumber(n);
                    return Integer.parseInt(n);
                })
                .reduce(0, Integer::sum);
    }

    private void validateNumber(String number) {
        int num;
        try {
            num = Integer.parseInt(number);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다: " + number);
        }

        if (num < 0) {
            throw new IllegalArgumentException("음수가 포함되었습니다: " + num);
        }
    }
}
