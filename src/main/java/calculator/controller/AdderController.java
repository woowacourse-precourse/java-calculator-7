package calculator.controller;

import calculator.model.Adder;
import calculator.view.InputView;

public class AdderController {
    public void run() {
        String[] resultOfInput = getInputString();
        String input = resultOfInput[0];
        String customSeperator = resultOfInput[1];
        int result = calculate(input, customSeperator);
    }

    private String[] getInputString() {
        return InputView.inputString();
    }

    private int calculate(String input, String customSeperator) {
        return Adder.makeResult(input, customSeperator);
    }

}