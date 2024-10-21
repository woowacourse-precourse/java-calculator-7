package calculator.model;

import java.util.Arrays;

public class Calculator {
    public int calculate(String input) {
        InputStringParser inputStringParser = new InputStringParser();
        input = inputStringParser.processInputString(input);
        if (input.isEmpty()) {
            return 0;
        }
        return Arrays.stream(inputStringParser.splitByDelimiter(input))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
