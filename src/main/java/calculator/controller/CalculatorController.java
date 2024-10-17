package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private String delimeter = ",:";

    public void start() {
        outputView.printStart();
        try {
            proceed();
        } catch (IllegalArgumentException error) {

        }
        end();
    }

    public void proceed() {
        String intputString = inputView.promptString();

    }

    public void end() {
        outputView.printEnd();
    }
}
