package calculator.controller;

import calculator.service.StringAddCalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringAddCalculatorController {
    private final StringAddCalculatorService stringAddCalculatorService;

    public StringAddCalculatorController(
            StringAddCalculatorService stringAddCalculatorService) {
        this.stringAddCalculatorService = stringAddCalculatorService;
    }

    public void run() {
        String inputValue = InputView.getInputValue();
        int result = stringAddCalculatorService.getResult(inputValue);
        OutputView.showResultMessage(result);
    }
}
