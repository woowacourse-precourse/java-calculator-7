package calculator.controller;

import calculator.domain.CalculatorService;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Long calculate(String input) {
        List<String> splitStrBySeparators = calculatorService.splitStrBySeparators(input);
        List<Long> numberList = calculatorService.makeNumberList(splitStrBySeparators);
        return calculatorService.sum(numberList);
    }

}
