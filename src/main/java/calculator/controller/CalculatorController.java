package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private InputView inputView;
    private OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            Delimiter delimiter = new Delimiter(inputView.getInputString());
            Number number = new Number(delimiter.getSplitString());
            outputView.printResult(number.calculateSum());

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;

        } finally {
            inputView.close();
        }
    }
}


