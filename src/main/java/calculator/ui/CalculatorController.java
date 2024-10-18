package calculator.ui;

import calculator.application.CalculatorService;
import calculator.application.dto.CalculatorSumRequest;

public class CalculatorController {

    private final CalculatorPresenter calculatorPresenter;
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorPresenter calculatorPresenter, CalculatorService calculatorService) {
        this.calculatorPresenter = calculatorPresenter;
        this.calculatorService = calculatorService;
    }

    public void stringAdditionCalculate() {
        String input = calculatorPresenter.splitAndSumInput();
        int result = calculatorService.splitAndSum(new CalculatorSumRequest(input));
        calculatorPresenter.splitAndSumOutput(result);
    }

}
