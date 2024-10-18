package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class StringAddCalculatorController {

    private final CalculatorService calculatorService;

    public StringAddCalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void playCalculator() {
        CalculatorView.inputView();
        CalculatorView.outputView(calculatorService.calculateSum(Console.readLine()));
    }

}