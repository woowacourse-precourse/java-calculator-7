package calculator;

import java.util.List;

import static java.lang.Integer.sum;

public class StringAddCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<Integer> numbers = InputParser.parse(input);

        return sum(numbers);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
