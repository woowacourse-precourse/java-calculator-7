package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        ConsoleView view = new ConsoleView();
        CalculatorController controller = new CalculatorController(calculator, view);
        controller.run();
    }
}
