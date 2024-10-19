package calculator;

import java.util.List;

public class SumCalculator {
    private final InputParser inputParser;
    private final StringAdder stringAdder;

    public SumCalculator() {
        inputParser = new InputParser();
        stringAdder = new StringAdder();
    }

    public int calculate(String input) {
        List<Integer> numbers = inputParser.parse(input);
        return stringAdder.sum(numbers);
    }
}
