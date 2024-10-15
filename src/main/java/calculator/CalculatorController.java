package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private OutputView outputView;
    private InputView inputView;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void calculate() {
        outputView.printStartMessage();
        inputView.readString();
    }
}
