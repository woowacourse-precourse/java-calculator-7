package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.StringSeparator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private StringSeparator stringSeparator;
    private InputView inputView;
    private OutputView outputView;
    private Calculator calculator;

    public CalculatorController() {
        this.stringSeparator = new StringSeparator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
    }

    public void run() {
        String str = inputView.inputString();
        stringSeparator.divideSeparator(str);
        outputView.outputResult(calculator);
    }
}
