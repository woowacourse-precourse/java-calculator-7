package calculator.controller;

import calculator.service.StringAddCalculatorService;

public class StringAddCalculatorController {

    private final StringAddCalculatorService stringAddCalculatorService;

    public StringAddCalculatorController(StringAddCalculatorService stringAddCalculatorService) {
        this.stringAddCalculatorService = stringAddCalculatorService;
    }

    public String stringAdd(String input){
        if(input.contains(" ")){
            throw new IllegalArgumentException();
        }
        if(input.isEmpty()){
            return "0";
        }
        if(input.matches("\\d+")){
            return input;
        }

        return stringAddCalculatorService.add(input);
    }
}
