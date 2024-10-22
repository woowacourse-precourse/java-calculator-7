package calculator.model.calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            return calculateSumWithCustomDelimiter(input);
        }
        return calculateSum(input);
    }

    private int calculateSum(String input) {
        String[] numbers = input.split("[,:]");
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
    private int calculateSumWithCustomDelimiter(String input) {
        String delimiter = input.substring(2, input.indexOf("\n"));
        String numbersPart = input.substring(input.indexOf("\n") + 1);
        String[] numbers = numbersPart.split(delimiter);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
