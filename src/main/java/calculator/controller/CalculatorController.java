package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.ApplicationView;
import java.math.BigDecimal;
import java.util.Objects;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ApplicationView applicationView;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.applicationView = new ApplicationView();
    }

    public String greeting() {
        return applicationView.requestInputMessage();
    }

    public String calculate(String input) {
        validateInput(input);
        BigDecimal result = calculatorService.parseInputAndCalculate(input);
        return applicationView.responseInputMessage(result);
    }

    private void validateInput(String input) {
        if (!Objects.equals(input, "") && !input.startsWith("//") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력 값은 공백, 숫자(양수), '//' 로 시작해야 합니다.");
        }
    }
}
