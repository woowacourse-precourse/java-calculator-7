package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {
    private static CalculatorController calculatorController;
    private static CalculatorService calculatorService = CalculatorService.getInstance();
    public static CalculatorController getInstance() {
        if (calculatorController == null) {
            calculatorController = new CalculatorController();
        }
        return calculatorController;
    }
    public Integer calculator(String text){
        if(!calculatorService.textValidation(text)){
            return 0;
        };
        String[] parsinged = calculatorService.parsing(text);
        calculatorService.parseValidation(parsinged);
        Integer result = calculatorService.sum(parsinged);
        return result;
    }
}
