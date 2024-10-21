package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {

    private final InputView inputView;
    private final ResultView resultView;
    private final CalculatorService calculatorService;

    public CalculatorController(InputView inputView, ResultView resultView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        String input = inputView.prompt();

        Long result = calculatorService.calculate(input);

        resultView.display(String.valueOf(result));
    }
}
