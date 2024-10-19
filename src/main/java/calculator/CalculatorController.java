package calculator;

import calculator.service.CalculatorService;
import calculator.util.CalculatorUtil;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final View view;
    private final InputValidator inputValidator;

    public CalculatorController(CalculatorService calculatorService, View view, InputValidator inputValidator) {
        this.calculatorService = calculatorService;
        this.view = view;
        this.inputValidator = inputValidator;
    }

    public void executeCalculation() {

        String input = view.executeInput();

        if (!inputValidator.isValidInput(input)) throw new IllegalArgumentException();

        Integer result = calculatorService.calculate(CalculatorUtil.getNumberList(input));

        view.printResultMessage(result);
    }
}
