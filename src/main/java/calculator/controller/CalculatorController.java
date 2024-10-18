package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.Number;
import calculator.view.InputView;

public class CalculatorController {
    private InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public int processInput() {
        String inputString = inputView.getInputString();

        Delimiter delimiter = new Delimiter(inputString);
        delimiter.checkCustomDelimiter();
        String[] splitNumbers = delimiter.splitString();

        Number number = new Number(splitNumbers);
        return number.addCalculator();
    }
}


