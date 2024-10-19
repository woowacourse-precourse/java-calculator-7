package calculator.controller;

import calculator.model.StringProcessor;
import calculator.view.InputView;
import calculator.view.ResultView;

public class StringCalculation {

    public void startCalculate() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        StringProcessor stringProcessor = new StringProcessor();

        String[] splitedString = stringProcessor.splitWithCustomDelimiter(inputView.inputString());
        resultView.printResult(stringProcessor.calculate(splitedString));

    }

}
