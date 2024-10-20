package calculator;

import static calculator.DelimiterGenerator.generateDelimiter;
import static calculator.UserInputReader.readInput;

import java.util.List;

public class Calculator {
    public void calculate() {

        String input = readInput();
        List<Character> delimiter = generateDelimiter(input);

    }
}
