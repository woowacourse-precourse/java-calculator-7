package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final OutputView outputView;
    private final InputView inputView;
    private final Separator separator;

    public Calculator() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.separator = new Separator();
    }

    public void calculate() {
        outputView.printStartMessage();
        String readString = inputView.readString();
        Numbers numbers = separator.getNumbers(readString);
        outputView.printResult(numbers);
    }
}