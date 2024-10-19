package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.viiew.CalculatorView;

public class Application {
    public static void main(String[] args) {

        CalculatorService calculatorService = new CalculatorService();
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorService, calculatorView);
        calculatorController.calculate();
    }
}
