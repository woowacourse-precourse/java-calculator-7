package calculator;

import calculator.application.CalculatorService;
import calculator.ui.CalculatorController;

public class Application {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(new CalculatorService());
        calculatorController.stringAdditionCalculate();
    }

}
