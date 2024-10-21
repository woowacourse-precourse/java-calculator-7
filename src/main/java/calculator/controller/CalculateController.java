package calculator.controller;

import calculator.StringCalculator;
import calculator.util.StringValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateController {
    public static void run(){
        String inputString = InputView.inputString();
        StringValidator.stringValidate(inputString);
        int sum = StringCalculator.calculateSum(inputString);
        OutputView.printOutput(sum);
    }
}
