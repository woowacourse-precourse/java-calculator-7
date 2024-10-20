package calculator.controller;

import calculator.dto.InputRequest;
import calculator.dto.OutputResponse;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    public void run() {
        InputRequest input = InputView.getInputRequest();
        OutputResponse result = calculatorService.calculate(input);
        OutputView.outputMessage(result);
    }
}
