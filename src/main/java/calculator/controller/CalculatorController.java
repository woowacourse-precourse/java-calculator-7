package calculator.controller;

import calculator.service.CalculatorService;

import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    public void start(){
        List<String> numbers = calculatorService.init();
        int sum =calculatorService.calculate(numbers);
        calculatorService.printResult(sum);
    }

}
