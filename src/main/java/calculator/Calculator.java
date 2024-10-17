package calculator;

import java.util.List;

public class Calculator {

    public static int calculate(List<String> inputs) {
        for (String input : inputs) {
            validateInput(input);
        }

        return inputs.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    private static void validateInput(String input) {
        try {
            int num = Integer.parseInt(input.trim());
            if (num <= 0) {
                throw new IllegalArgumentException("양수만 계산 가능합니다.");
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 계산 가능합니다.");
        }
    }
}
