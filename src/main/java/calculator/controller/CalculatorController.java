package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.ApplicationView;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ApplicationView applicationView;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.applicationView = new ApplicationView();
    }

    public String greeting() {
        return applicationView.printRequestInputMessage();
    }

    public String calculate(String input) {
        validateInput(input);
        int result = calculatorService.parseInputAndCalculate(input);

        if (result == 1) {
            return "성공";
        } else {
            return "실패";
        }
    }

    private void validateInput(String input) {
        if (!input.startsWith("//") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력 값이 숫자 또는 //로 시작해야 합니다.");
        }
    }
}
