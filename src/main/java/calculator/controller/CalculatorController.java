package calculator.controller;

import calculator.util.Calculate;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void callCalculator() {
        endCalculate(doCalculate(startCalculate()));
    }

    public String startCalculate() {
        InputView.printInputMessage();
        return InputView.userInput();
    }

    public Integer doCalculate(String userInput) {
        return Calculate.calculateUserInputSum(userInput);
    }

    public void endCalculate(Integer numbersSum) {
        OutputView.printCalculateResult(numbersSum);
    }
}
