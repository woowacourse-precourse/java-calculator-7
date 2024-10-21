package calculator.calculator;

import calculator.view.InputHandler;
import calculator.view.OutputHandler;

public class MainCalculator {
    public static void execute() {
        String input = InputHandler.getInput();

        try {
            int result = StringCalculator.calculate(input);
            OutputHandler.printResult(result);
        } catch (IllegalArgumentException e) {
            OutputHandler.printError(e.getMessage());
        }
    }
}
