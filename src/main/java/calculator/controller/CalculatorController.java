package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run() {
        OutputView.printInputStringMessage();

        String input = InputView.readInputString();

        String separator = findSeparator(input);
    }

    private String findSeparator(String input) {
        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");

            return input.substring(2, index);
        } else {
            return "[,:]";
        }
    }
}
