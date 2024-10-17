package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class FunctionOperator {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void operator() {
        String input = inputView.input();
    }

}
