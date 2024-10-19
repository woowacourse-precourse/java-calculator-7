package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private OutputView outputView;
    private InputView inputView;
    private Separator separator;
    private Numbers numbers;

    public Calculator() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.separator = new Separator();
    }

    public void calculate() {
        outputView.printStartMessage();
        String readString = inputView.readString();
        numbers = separator.getNumbers(readString);
        outputView.printResult(numbers);
    }
}
