package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.StringInputService;
import calculator.service.SumCalculateService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final StringInputService stringInputService = new StringInputService();
    private final SumCalculateService sumCalculateService = new SumCalculateService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        String input = inputView.inputString();
        if (stringInputService.isEmptyInput(input)) {
            outputView.printResult(0);
            return;
        }
        Calculator calculator = new Calculator(stringInputService.processInput(input));
        int sum = sumCalculateService.calculateSum(calculator);
        outputView.printResult(sum);
    }
}
