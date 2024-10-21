package controller;

import calculator.StringCalculator;
import util.StringValidator;
import view.InputView;
import view.OutputView;

public class CalculateController {
    public static void run(){
        try{
            String inputString = InputView.inputString();
            StringValidator.stringValidate(inputString);
            int sum = StringCalculator.calculateSum(inputString);
            OutputView.printOutput(sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
