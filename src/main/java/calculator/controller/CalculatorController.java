package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public static void run() {
        OutputView.displayInputMessage();
        String input = InputView.getInput();
        int result = CalculatorService.add(input);
        OutputView.printResult(result);
    }
}
