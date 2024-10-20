package calculator.domain.calculator.presentation;

import calculator.domain.calculator.service.StringCalculatorService;

public class StringCalculatorController {

    private static StringCalculatorController instance;
    private final StringCalculatorService stringCalculatorService;

    private StringCalculatorController(StringCalculatorService stringCalculatorService) {
        this.stringCalculatorService = stringCalculatorService;
    }

    public static StringCalculatorController getInstance(
            StringCalculatorService stringCalculatorService
    ) {
        if (instance == null) {
            instance = new StringCalculatorController(stringCalculatorService);
        }
        return instance;
    }

    public int calculateString(String input) {
        return stringCalculatorService.calculate(input);
    }
}