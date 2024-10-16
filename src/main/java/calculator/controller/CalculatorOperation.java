package calculator.controller;

import calculator.service.StringSplit;
import calculator.view.InputView;

public class CalculatorOperation {

    private String inputString;

    public void operateCalculator() {
        getUserInputByView();
        splitDelimiterAndOperand();
    }

    private void getUserInputByView() {
        InputView inputView = new InputView();
        inputString = inputView.getUserInput();
    }

    private void splitDelimiterAndOperand() {
        StringSplit stringSplit = new StringSplit(inputString);
        stringSplit.preprocessDelimiter();
        stringSplit.splitAndSaveOperands();
    }
}
