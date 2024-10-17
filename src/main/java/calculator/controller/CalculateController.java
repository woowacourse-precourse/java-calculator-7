package calculator.controller;

import calculator.model.Numbers;
import calculator.utils.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateController {

    private final OutputView outputView;
    private final InputView inputView;
    private final Parser parser;

    public CalculateController(OutputView outputView, InputView inputView, Parser parser) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.parser = parser;
    }

    public void start() {
        outputView.printStartMessage();
        Numbers numbers = new Numbers(parser.parseInput(inputView.getString()));
        outputView.printResultMessage(numbers.sumNumbers());
    }
}
