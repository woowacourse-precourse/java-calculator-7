package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private OutputView outputView;
    private InputView inputView;
    private Separator separator;
    private Numbers numbers;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.separator = new Separator();
    }

    public void calculate() {
        outputView.printStartMessage();
        String readString = inputView.readString();
        numbers = separator.getNumberList(readString);
        outputView.printResult(numbers);
    }
}
