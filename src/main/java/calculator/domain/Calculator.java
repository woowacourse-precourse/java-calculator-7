package calculator.domain;

import calculator.util.InputParser;

import java.util.ArrayList;
import static calculator.util.InputValidator.validate;

public class Calculator {
    private final String input;
    private final InputParser inputParser;

    public Calculator(String input, InputParser inputParser) {
        validate(input);
        this.input = input;
        this.inputParser = inputParser;
    }

    public int add(String input) {
        return sum(inputParser.parse(input));
    }

    public int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            int n;
            try {
                n = Integer.parseInt(number);
                if (n < 0) throw new IllegalArgumentException("입력은 음수를 포함할 수 없습니다.");

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            }
            result += n;
        }
        return result;
    }
}
