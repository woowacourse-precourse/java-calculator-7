package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorService calcService;
    private final CalculatorView calcView;

    public CalculatorController() {
        this.calcService = new CalculatorService();
        this.calcView = new CalculatorView();
    }

    public void run() {
        String input = calcView.getInput(); // 사용자 입력받기

        int result = calcService.caculate(input);
        calcView.displayResult(result);
    }
}
