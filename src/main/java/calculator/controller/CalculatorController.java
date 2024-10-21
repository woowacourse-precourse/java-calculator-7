package calculator.controller;

import calculator.util.Calculate;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void callCalculator() {
        String userInput = startCalculate();
        Integer userInputSum = doCalculate(userInput);
        endCalculate(userInputSum);
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
