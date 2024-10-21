package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;


    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        String input = inputView.numbersInputView();

        Calculator calculator = new Calculator();
        int result = calculator.calculate(input);

        outputView.printResult(result);
    }


}
