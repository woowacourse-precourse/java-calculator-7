package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void startCalculation(){
        Calculator calculator = new Calculator();
        InputView.printInputMessage();
        String input = InputView.getInput();

        Integer result = calculator.add(input);

        OutputView outputView = new OutputView(result);

        outputView.printResult();
    }
}
