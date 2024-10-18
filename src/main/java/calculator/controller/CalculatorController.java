package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    public int input(String input) {
        int result = CalculatorService.calculate(input);
        return result;
    }
}
