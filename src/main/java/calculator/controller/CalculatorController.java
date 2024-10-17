package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    public void input(String s){
        int sum = calculatorService.sum(s);
        System.out.println("결과 : "+sum);
    }

}
