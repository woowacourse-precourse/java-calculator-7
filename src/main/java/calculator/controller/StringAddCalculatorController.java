package calculator.controller;

import calculator.service.StringAddCalculatorService;

public class StringAddCalculatorController {

    private final StringAddCalculatorService stringAddCalculatorService;

    public StringAddCalculatorController(StringAddCalculatorService stringAddCalculatorService) {
        this.stringAddCalculatorService = stringAddCalculatorService;
    }

    public String stringAdd(String input){
        return stringAddCalculatorService.add(input);
    }
}
