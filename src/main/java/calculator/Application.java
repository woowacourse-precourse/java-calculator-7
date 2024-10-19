package calculator;

import calculator.common.io.Input;
import calculator.common.io.Output;
import calculator.service.CalculatorService;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        CalculatorService calculatorService = new CalculatorService();

        try {
            String userInput = input.getInput();

            if (isEmpty(userInput)) {
                output.printResult(0);
                return;
            }
            int result = calculatorService.calculate(userInput);
            output.printResult(result);
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            throw e;
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}