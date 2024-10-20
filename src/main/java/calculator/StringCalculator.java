package calculator;

import java.util.Arrays;

public class StringCalculator {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = parseNumbers(input);
        return sum(numbers);
    }

    private String[] parseNumbers(String input) {
        if (input.startsWith("//")) {
            return parseCustomDelimiter(input);
        }
        return input.split("[,:]");
    }

    private String[] parseCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");
        String delimiter = input.substring(2, delimiterIndex);
        String numbers = input.substring(delimiterIndex + 2);
        return numbers.split(delimiter);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
