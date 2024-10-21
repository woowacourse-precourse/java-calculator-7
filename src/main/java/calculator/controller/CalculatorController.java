package calculator.controller;

import calculator.service.StringCalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final StringCalculatorService calculatorService;

    // 생성자를 통해 서비스 객체를 주입
    public CalculatorController(StringCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // 입력을 처리하고 View로 전달
    public void processInput(String input) {
        int result = calculatorService.add(input);
        CalculatorView.displayResult(result);
    }
}
