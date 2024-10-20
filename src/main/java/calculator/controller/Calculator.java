package calculator.controller;

import calculator.domain.Data;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    public void run() {
        String input = readInput();

        Data data = new Data(input);
        handleUserInput(data);

        int result = makeResult(data);
        printOutput(result);
    }

    private String readInput() {
        return InputView.readUserInput();
    }

    private void handleUserInput(Data data) {
        data.handleInput();
    }

    private int makeResult(Data data) {
        return data.calculateAddition();
    }

    private void printOutput(int result) {
        OutputView.printResult(result);
    }
}
