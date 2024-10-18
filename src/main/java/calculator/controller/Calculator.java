package calculator.controller;

import calculator.service.CalculatorService;

public class Calculator implements Device {
    CalculatorService calculatorService = new CalculatorService();

    public Integer run(String inputString) {
        return calculatorService.executeAdd(inputString);
    }
}
