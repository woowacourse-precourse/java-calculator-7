package calculator.controller;

import calculator.service.Calculator;
import calculator.service.CustomSeperator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculateController {

    public void run() {
        String input = InputView.receiveInput();

        CustomSeperator customSeperator = new CustomSeperator();
        customSeperator.updateCustomSeperator(input);
        List<Double> number = InputView.getNumber(input);
        Double sum = Calculator.sum(number);

        OutputView.printSumResult(sum);
    }
}