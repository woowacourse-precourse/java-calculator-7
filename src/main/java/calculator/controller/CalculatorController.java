package calculator.controller;

import calculator.domain.InputStringSeparator;
import calculator.domain.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final SumCalculator sumCalculator;

    public CalculatorController() {
        inputView = new InputView();
        outputView = new OutputView();
        sumCalculator = new SumCalculator();
    }

    public void startCalculator() {
        outputView.printStartMessage();
        InputStringSeparator inputStringSeparator = new InputStringSeparator(inputView.getString());
        outputView.printResult(sumCalculator.getResult(inputStringSeparator.getInputNumber()));
    }
}
