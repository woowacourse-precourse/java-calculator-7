package calculator;

import calculator.controller.CalculatorController;
import calculator.ui.ConsoleUI;
import calculator.ui.UserInterface;


public class Application {
    public static void main(String[] args) {
        UserInterface ui = new ConsoleUI();
        CalculatorController calculatorController = new CalculatorController(ui);
        calculatorController.run();
    }
}
