package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Division;
import calculator.io.InputView;
import calculator.io.OutputView;
import java.util.List;

public class CalculatorController {

    private Division division = new Division();

    public void start() {
        String inputString = InputView.printInputAddString();
        List<String> digits = division.split(inputString);
        result(digits);
    }

    private void result(List<String> digits) {
        int sum = Calculator.sumPositiveNumbers(digits);
        OutputView.printResult(sum);
    }

}

