package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.startCalculator();
    }
}
