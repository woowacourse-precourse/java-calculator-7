package calculator.ui;

import calculator.application.CalculatorService;
import calculator.application.dto.CalculatorSumRequest;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    private final CalculatorPresenter calculatorPresenter;
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorPresenter calculatorPresenter, CalculatorService calculatorService) {
        this.calculatorPresenter = calculatorPresenter;
        this.calculatorService = calculatorService;
    }

    public void stringAdditionCalculate() {
        String input = calculatorPresenter.splitAndSumInput();
        System.out.println(input);
        int result = calculatorService.splitAndSum(new CalculatorSumRequest(input));
        calculatorPresenter.splitAndSumOutput(result);
    }

}
