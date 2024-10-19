package calculator.ui;

import calculator.application.CalculateService;
import calculator.ui.view.CalculatorInputView;
import calculator.ui.view.CalculatorOutputView;

public class CalculatorController {

    private final CalculatorInputView calculatorInputView;
    private final CalculatorOutputView calculatorOutputView;
    private final CalculateService calculateService;

    public CalculatorController(
            CalculatorInputView calculatorInputView,
            CalculatorOutputView calculatorOutputView,
            CalculateService calculateService
    ) {
        this. calculatorInputView = calculatorInputView;
        this.calculatorOutputView = calculatorOutputView;
        this.calculateService = calculateService;
    }

    public void stringAdditionCalculate() {
        String command = calculatorInputView.splitAndSumInput();
        int result = calculateService.splitAndSum(command);
        calculatorOutputView.splitAndSumOutput(result);
    }

}
