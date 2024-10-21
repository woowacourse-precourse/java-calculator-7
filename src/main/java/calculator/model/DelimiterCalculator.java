package calculator.model;

import java.util.Arrays;

public class DelimiterCalculator {
    private final int result;

    public DelimiterCalculator(InputProcessor inputProcessor) {
        this.result = sum(inputProcessor);
    }

    public int getResult() {
        return result;
    }

    public int sum(InputProcessor inputProcessor) {
        String[] numbers = inputProcessor.splitNumbers();
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}