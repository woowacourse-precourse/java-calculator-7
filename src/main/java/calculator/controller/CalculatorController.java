package calculator.controller;

import calculator.service.CalculatorService;
import java.util.Arrays;

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
        if(calculatorService.textValidation(text)){
            String[] parsinged = calculatorService.parsing(text);
            Integer result = calculatorService.sum(parsinged);
            return result;
        };
        return 0;
    }
}
