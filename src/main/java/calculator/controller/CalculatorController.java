package calculator.controller;

import calculator.model.Numbers;
import calculator.model.StringHandler;
import calculator.view.InputView;
import calculator.view.Output;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        StringHandler stringHandler = setCalculationInput();
        Numbers numbers = extractString(stringHandler);
    }

    private StringHandler setCalculationInput() {
        outputView.printMessage(Output.START_MESSAGE);
        return StringHandler.createStringHandler(inputView.inputString());
    }

    private Numbers extractString(StringHandler stringHandler) {
        stringHandler.extractDelimiter();
        return stringHandler.extractNumbers();
    }


}
