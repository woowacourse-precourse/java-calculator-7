package calculator.controller;

import calculator.domain.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void startCalculate() {
        OutputView.printCalculateStartMessage();
        String input = InputView.inputString();
        int result;
        if (input.equals("0")) {
            result = 0;
        } else {
            result = StringParser.calculateInput(input);
        }
        OutputView.printResultMessage(result);
    }
}
