package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator;
    private final CalculatorView calcView;

    public CalculatorController() {
        this.calculator = new Calculator();
        this.calcView = new CalculatorView();
    }

    public void run() {
        String input = calcView.getInput(); // 사용자 입력받기

        int result = calculator.caculate(input);
        calcView.displayResult(result);
    }
}
