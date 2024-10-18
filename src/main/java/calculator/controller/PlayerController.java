package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class PlayerController {
    private Separator separator;
    private final InputView inputView;
    private final OutputView outputView;

    public PlayerController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
    public void process() {
        input();
        calculate();
    }
    private void input() {
        String numbers = inputView.inputNumbers();
        separator = new Separator(numbers);
    }
    private void calculate() {
        List<String> extractedNumbers = separator.getExtractedNumbers();
        Numbers numbers = new Numbers(extractedNumbers);
        outputView.printResult(numbers.toString());
    }
}
