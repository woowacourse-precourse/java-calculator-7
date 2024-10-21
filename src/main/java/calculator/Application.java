package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class Application {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new CalculatorInputView(), new CalculatorOutputView(), new CalculatorService());

        calculatorController.calculate();
    }
}
