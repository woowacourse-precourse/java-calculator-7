package calculator.controller;

import calculator.model.Calculate;
import calculator.model.Numbers;
import calculator.view.InputView;
import java.util.List;

public class CalculatorController {

    public void callCalculator() {

    }

    public String startCalculate() {
        InputView.printInputMessage();
        return InputView.userInput();
    }

    public Integer doCalculate(String userInput) {
        List<String> calculate = new Calculate(userInput).getSplitUserInput();
        return new Numbers(calculate).calculateNumbersSum();
    }
}
