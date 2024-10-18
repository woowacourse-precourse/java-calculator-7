package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    public void run(){
        String input = InputView.input();
        int result = calculatorService.calculate(input);
        OutputView.printResult(result);
    }
}
