package calculator.calculator;

import calculator.input.InputValidator;
import java.util.Arrays;

public class Calculator {

    private final Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public int add(String input) {
        InputValidator.validateInputBlank(input);

        return Arrays.stream(parser.split(input))
                .mapToInt(Integer::parseInt)
                .peek(InputValidator::validateNonNegative)
                .sum();
    }
}
