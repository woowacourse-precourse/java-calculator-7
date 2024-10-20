package calculator;

import java.util.List;

public class StringCalculator {
    private final NumberParser numberParser;

    public StringCalculator() {
        this.numberParser = new NumberParser();
    }

    public int calculateSum(String input) {
        List<Integer> numbers = numberParser.parse(input);
        return sum(numbers);
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
