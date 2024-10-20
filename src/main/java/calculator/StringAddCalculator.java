package calculator;

import java.util.List;


public class StringAddCalculator {
    private final InputParser inputParser;

    public StringAddCalculator(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<Integer> numbers = inputParser.parse();

        return sum(numbers);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
