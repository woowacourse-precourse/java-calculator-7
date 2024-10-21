package calculator.controller;

import calculator.model.Adder;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AdderController {
    public void run() {
        String[] resultOfInput = getInputString();
        String input = resultOfInput[0];
        String customSeperator = resultOfInput[1];
        int result = calculate(input, customSeperator);
        printResult(result);
    }

    private String[] getInputString() {
        return InputView.inputString();
    }

    private int calculate(String input, String customSeperator) {
        return Adder.makeResult(input, customSeperator);
    }

    private void printResult(int result) {
        OutputView.printResult(result);
    }
}