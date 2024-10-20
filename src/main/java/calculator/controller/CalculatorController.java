package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public int run(String input){
        return calculatorService.addInput(input);
    }
}
