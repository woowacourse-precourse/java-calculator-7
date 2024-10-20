package calculator.controller;

import calculator.view.CalculatorOutputView;

public class CalculatorController {

    private final CalculatorOutputView calculatorOutputView;

    public CalculatorController(CalculatorOutputView calculatorOutputView) {
        this.calculatorOutputView = calculatorOutputView;
    }

    public void processInput(String inputStr) {
        if (inputStr.isEmpty()) {
            calculatorOutputView.printResult("0");
        }
    }
}
