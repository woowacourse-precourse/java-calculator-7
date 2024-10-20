package calculator.controller;

import calculator.service.StringAddCalculatorService;
import calculator.validator.InputValidator;

public class StringAddCalculatorController {

    private final StringAddCalculatorService stringAddCalculatorService;
    private final InputValidator inputValidator;

    public StringAddCalculatorController(StringAddCalculatorService stringAddCalculatorService, InputValidator inputValidator) {
        this.stringAddCalculatorService = stringAddCalculatorService;
        this.inputValidator = new InputValidator();
    }

    public String getStringAdd(String input){
        inputValidator.validateNoSpace(input);
        return stringAddCalculatorService.add(input);
    }
}
