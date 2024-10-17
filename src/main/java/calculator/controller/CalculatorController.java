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


    public void start() {
        String input = calcView.getInput(); // 사용자 입력받기
        try {
            int result = calcService.caculate(input);
            calcView.displayResult(result);
        } catch (IllegalArgumentException iae) { //예외가 발생하면
            System.exit(1); //출력없이 종료
        }
    }
}
