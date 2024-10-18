package calculator.domain.calculator.presentation;

import calculator.domain.calculator.service.StringCalculatorService;

public class StringCalculatorController {

    private final StringCalculatorService stringCalculatorService;

    public StringCalculatorController(StringCalculatorService stringCalculatorService) {
        this.stringCalculatorService = stringCalculatorService;
    }

    public int calculateString(String input) {
        int calculate = stringCalculatorService.calculate(input);

        return calculate;
    }

}
