package calculator.domain;

import java.util.Arrays;

public class SumCalculator {
    private final ArrayUtils arrayUtils = new ArrayUtils();
    private final DelimiterSplitter delimiterSplitter = new DelimiterSplitter();

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] inputNumbers = delimiterSplitter.split(input);
        int[] numbers = arrayUtils.convert(inputNumbers);

        return Arrays.stream(numbers)
                .sum();
    }
}
