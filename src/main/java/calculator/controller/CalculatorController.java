package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final CalculatorModel calculatorModel;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.calculatorModel = new CalculatorModel();
        this.outputView = new OutputView();
    }

    public void run() {
        String[] numbers = inputView.inputCalculateNumber();
        int result = calculatorModel.addNumber(numbers);
        outputView.printResult(result);

    }

}
