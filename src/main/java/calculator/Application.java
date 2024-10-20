package calculator;

import calculator.handler.InputHandler;
import calculator.handler.OutputHandler;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String input_str = InputHandler.getInput();
        try {
            Integer result = calculator.calculate(input_str);
            OutputHandler.printResult(result);
        } catch (IllegalArgumentException e) {
            OutputHandler.printError(e.getMessage());
            throw e;
        }
    }
}
