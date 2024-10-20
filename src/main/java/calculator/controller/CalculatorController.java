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

    public CalculatorController(Calculator calculator, StringSeparator stringSeparator, InputView inputView,
                                OutputView outputView) {
        this.calculator = calculator;
        this.stringSeparator = stringSeparator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String str = inputView.inputString();
        stringSeparator.extractAndProcessSeparators(str);
        outputView.outputResult(calculator);
    }
}
