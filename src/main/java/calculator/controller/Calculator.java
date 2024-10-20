package calculator.controller;

import calculator.domain.Data;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    public void run() {
        Data data = new Data(InputView.readUserInput());
        OutputView.printResult(data.calculateAddition());
    }
}
