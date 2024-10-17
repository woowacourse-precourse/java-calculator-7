package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    private static final String RESULT_MESSAGE = "결과 : ";

    public CalculatorController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void start() {
        String stringToAdd = inputView.readStringToAdd();
        int sum = calculator.getSum(stringToAdd);
        outputView.writeln(RESULT_MESSAGE + sum);
    }
}
