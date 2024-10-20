package calculator.controller;

import calculator.domain.Data;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    public void run() {
        String input = readInput();
        Data data = handleInput(input);
        int result = makeResult(data);
        printOutput(result);
    }

    private String readInput() {
        return InputView.readUserInput();
    }

    private Data handleInput(String input) {
        return new Data(input);
    }

    private int makeResult(Data data) {
        return data.calculateAddition();
    }

    private void printOutput(int result) {
        OutputView.printResult(result);
    }
}
