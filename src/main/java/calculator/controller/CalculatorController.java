package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator ;
    private final CalculatorView calcView;

    public CalculatorController(Calculator calculator, CalculatorView calcView) {
        this.calculator = calculator;
        this.calcView = calcView;
    }

    public void run() {
        String input = calcView.getInput();
        int result = calculator.calculate(input);
        calcView.displayResult(result);
    }//run
}//class
