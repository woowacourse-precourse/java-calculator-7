package calculator.controller;

import calculator.view.OutputView;
import calculator.view.InputView;
import calculator.model.Model;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Model model;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.model = new Model();
    }

    public void run() {
        String input = inputView.inputString();
        int sum = model.result(input);
        outputView.printResult(sum);
    }

}
