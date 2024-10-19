package calculator;

import java.util.List;
import java.util.Objects;

public class SumCalculator {
    private final InputParser inputParser;
    private final StringAdder stringAdder;

    public SumCalculator() {
        inputParser = new InputParser();
        stringAdder = new StringAdder();
    }

    public int calculate(String input) {
        if (Objects.equals(input, "")) {
            return 0;
        }
        List<Integer> numbers = inputParser.parse(input);
        return stringAdder.sum(numbers);
    }
}
