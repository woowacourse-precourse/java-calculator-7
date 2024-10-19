package calculator;

import calculator.controller.CalculatorController;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorView);

        calculatorController.start();
    }
}
