package calculator.controller;

import calculator.domain.InputStringSeparator;
import calculator.domain.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private InputView inputView;
    private OutputView outputView;
    private InputStringSeparator inputStringSeparator;
    private SumCalculator sumCalculator;

    public CalculatorController() {
        inputView = new InputView();
        outputView = new OutputView();
        sumCalculator = new SumCalculator();
    }

    public void startCalculator() {
        outputView.printStartMessage();
        inputStringSeparator = new InputStringSeparator(inputView.getString());
        outputView.printResult(sumCalculator.getResult(inputStringSeparator.getInputNumber()));
    }
}
