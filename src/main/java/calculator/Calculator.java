package calculator;

import calculator.util.DelimiterExtractor;
import calculator.view.InputView;

public class Calculator {
    protected final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String input = inputView.getInput();



    }
}
