package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        ConsoleView consoleView = new ConsoleView();
        CalculatorController calculatorController = new CalculatorController(calculatorService, consoleView);

        calculatorController.run();
    }
}
