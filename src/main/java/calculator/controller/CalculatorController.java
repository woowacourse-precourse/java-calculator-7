package calculator.controller;

import calculator.domain.CalcTarget;
import calculator.service.CalculatorService;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class CalculatorController {
    private final CalculatorInputView calculatorInputView;
    private final CalculatorService calculatorService;
    private final CalculatorOutputView calculatorOutputView;

    public CalculatorController(CalculatorInputView calculatorInputView, CalculatorService calculatorService, CalculatorOutputView calculatorOutputView) {
        this.calculatorInputView = calculatorInputView;
        this.calculatorService = calculatorService;
        this.calculatorOutputView = calculatorOutputView;
    }

    public void run() {
        CalcTarget input = calculatorInputView.printInputView();
        int result = calculatorService.calculate(input);
        calculatorOutputView.printOutputView(result);
    }
}
