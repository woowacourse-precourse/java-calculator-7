package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = InputHandler.getInput();
        String[] numbers = DelimeterParser.parse(input);
        List<Long> validNumbers = InputValidator.validateInput(numbers);
        long result = Calculator.add(validNumbers);
        OutputHandler.printResult(result);
    }
}
