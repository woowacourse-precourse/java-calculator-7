package calculator.domain;

import calculator.util.InputParser;

import java.util.ArrayList;
import static calculator.util.InputValidator.validate;

public class Calculator {
    private final String input;

    public Calculator(String input) {
        validate(input);
        this.input = input;
    }

    public int add(ArrayList<Integer> numbers) {
        int result = 0;
        for (int n : numbers) {
            result += n;
        }
        return result;
    }
}
