package calculator.controller;


import calculator.service.CalculatorService;
import calculator.util.Separator;
import java.util.List;

public class CalculatorController {

    private CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    private final CalculatorService calculatorService;

    // private 클래스이므로 외부에서 접근할 수 없다.
    private static class CalculatorControllerHolder {
        private static final CalculatorController INSTANCE = new CalculatorController(CalculatorService.getInstance());
    }

    public static CalculatorController getInstance() {
        return CalculatorControllerHolder.INSTANCE;
    }

    public Long calculateNumbers(String input) {
        List<String> stringNumbers = Separator.separate(input);
        List<Long> numbers = Separator.parseEachNumber(stringNumbers);
        return calculatorService.calculateNumbers(numbers);
    }

}
