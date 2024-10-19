package calculator;

import calculator.service.CalculatorService;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final View view;

    public CalculatorController(CalculatorService calculatorService, View view) {
        this.calculatorService = calculatorService;
        this.view = view;
    }

    public String executeInput() {
        view.printMessage();
        return view.input();
    }

    public void executeOutput(Integer result) {
        view.printResultMessage(result);
    }

    public Integer executeCalculation(List<Integer> numbers) {
        return calculatorService.calculate(numbers);
    }
}
