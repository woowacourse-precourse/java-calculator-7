package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class IOProcessor {
    private final InputView inputView;
    private final OutputView outputView;
    private final Preprocessing preprocessing;

    public IOProcessor(InputView inputView, OutputView outputView, Preprocessing preprocessing) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.preprocessing = preprocessing;
    }

    public List<String> processInput() {
        outputView.askInput();
        String input = inputView.askInput();
        return preprocessing.processInput(input);
    }

    public void displayResult(int result) {
        outputView.printAnswer(result);
    }
}
