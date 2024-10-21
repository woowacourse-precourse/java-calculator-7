package calculator.controller;

import calculator.model.Adder;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AdderController {
    public void run() {
        String[] resultOfInput = getInputString();
        String input = resultOfInput[0];
        String customDelimiter = resultOfInput[1];
        int result = calculate(input, customDelimiter);
        printResult(result);
    }

    private String[] getInputString() {
        return InputView.inputString();
    }

    private int calculate(String input, String customDelimiter) {
        return Adder.makeResult(input, customDelimiter);
    }

    private void printResult(int result) {
        OutputView.printResult(result);
    }
}