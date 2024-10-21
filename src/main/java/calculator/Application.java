package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.ConsoleInputView;
import calculator.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView input = new ConsoleInputView();
        CalculatorService calculatorService = new CalculatorService();
        ConsoleOutputView output = new ConsoleOutputView();
        CalculatorController controller = new CalculatorController(input, calculatorService, output);
        controller.run();
    }
}
