package calculator;

import java.util.Arrays;

public class Calculator {
    private final InputStringParser inputStringParser;

    public Calculator() {
        inputStringParser = new InputStringParser();
    }

    public int calculate(String input) {
        input = inputStringParser.processInputString(input);
        if (input.isEmpty()) {
            return 0;
        }
        return Arrays.stream(inputStringParser.parseAndSplit(input))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
