package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public static void run(){
        OutputView.printCommand();
        String input=InputView.enterInput();
        int result= Calculator.inputCalculate(input);
        OutputView.printResult(result);
    }
}
