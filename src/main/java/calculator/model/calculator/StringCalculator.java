package calculator.model.calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return calculateSum(input);
    }

    private int calculateSum(String input) {
        String[] numbers = input.split("[,:]");
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
