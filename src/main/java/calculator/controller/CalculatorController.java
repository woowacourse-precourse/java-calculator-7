package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorService calculatorService, CalculatorView calculatorView) {
        this.calculatorService = calculatorService;
        this.calculatorView = calculatorView;
    }

    public int run() {
        // View로부터 입력을 받아 처리
        String input = calculatorView.getInput();

        // 계산 처리
        int result = calculatorService.calculate(input);

        // 결과를 View에 전달하여 출력
        calculatorView.displayOutput(result);

        return result;
    }
}
