package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = new Calculator();
    }

    public void control() {
        outputView.showStartComments();
        List<Integer> userInputs = inputView.getInputFromUserForAddition();
        int sum = calculator.calculate(userInputs);
        outputView.showCommentForResult(sum);
    }

}
