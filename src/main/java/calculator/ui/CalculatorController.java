package calculator.ui;

import calculator.application.CalculatorService;
import calculator.ui.view.CalculatorInputView;
import calculator.ui.view.CalculatorOutputView;

public class CalculatorController {

    private final CalculatorInputView calculatorInputView;
    private final CalculatorOutputView calculatorOutputView;
    private final CalculatorService calculatorService;

    public CalculatorController(
            CalculatorInputView calculatorInputView,
            CalculatorOutputView calculatorOutputView,
            CalculatorService calculatorService
    ) {
        this. calculatorInputView = calculatorInputView;
        this.calculatorOutputView = calculatorOutputView;
        this.calculatorService = calculatorService;
    }

    public void stringAdditionCalculate() {
        String command = calculatorInputView.splitAndSumInput();
        int result = calculatorService.splitAndSum(command);
        calculatorOutputView.splitAndSumOutput(result);
    }

}
