package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.view.ConsoleInputView;
import calculator.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView input = new ConsoleInputView();
        Calculator calculator = new Calculator();
        ConsoleOutputView output = new ConsoleOutputView();
        CalculatorController controller = new CalculatorController(input, calculator,output);
        controller.run();
    }
}
