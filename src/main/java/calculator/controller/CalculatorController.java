package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Calculator calculator = new Calculator();

    public void start() {
        outputView.printInputMessage();
        String input = inputView.readLine();
        calculator.calculate(input);
        String result = calculator.getResult();
        outputView.printResultMessage(result);
    }
}
