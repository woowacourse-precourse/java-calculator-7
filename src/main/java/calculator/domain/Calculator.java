package calculator.domain;

import calculator.global.ui.InputView;
import calculator.global.ui.OutputView;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    public Calculator() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.startMessage();
        outputView.resultMessage(sum(getNumbers(inputString())));
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private String inputString() {
        return inputView.inputString();
    }

    private int[] getNumbers(String input) {
        return inputView.parseIntNumbers(input);
    }
}
