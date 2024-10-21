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
        this.inputView = InputView.createInputView();
        this.outputView = OutputView.createOutputView();
    }

    public void run() {
        StringHandler stringHandler = setCalculationInput();
        Numbers numbers = extractString(stringHandler);
        calculate(numbers);
    }

    private StringHandler setCalculationInput() {
        outputView.printMessage(Output.START_MESSAGE);
        return StringHandler.createStringHandler(inputView.inputString());
    }

    private Numbers extractString(StringHandler stringHandler) {
        stringHandler.extractDelimiter();
        return stringHandler.extractNumbers();
    }

    private void calculate(Numbers numbers) {
        outputView.printMessage(Output.RESULT_MESSAGE, numbers.add());
    }

}
