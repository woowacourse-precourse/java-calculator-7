package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.StringCalculation;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculationController {

    public void startCalculate() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        StringCalculation stringCalculation = new StringCalculation();
        Delimiter delimiter = new Delimiter();

        String[] splitedString = delimiter.splitWithCustomDelimiter(inputView.inputString());
        resultView.printResult(stringCalculation.calculate(splitedString));

    }

}
