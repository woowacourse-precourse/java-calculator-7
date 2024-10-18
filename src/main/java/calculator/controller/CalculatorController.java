package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;

public class CalculatorController {
    private InputView inputView;


    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {

        String input = inputView.numbersInputView();

        Calculator calculator = new Calculator();
        calculator.calculate(input);

    }


}
