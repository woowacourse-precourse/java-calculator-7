package calculator.interfaces;

import calculator.domain.CalculatorService;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Long calculate(String inputStr) {
        calculatorService.validateUserInput(inputStr);
        List<String> splitStrBySeparators = calculatorService.splitStrBySeparators(inputStr);
        List<Long> numberList = calculatorService.makeNumberList(splitStrBySeparators);
        return calculatorService.sum(numberList);
    }

}
