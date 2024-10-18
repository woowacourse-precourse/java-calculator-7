package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();


    public void start() {
        String input = readInput();
        StringCalculator calculator = new StringCalculator(input);
        outputView.printResult(calculator.sum());
    }

    private String readInput() {
        outputView.printInputGuide();
        return inputView.readInput();
    }
}
