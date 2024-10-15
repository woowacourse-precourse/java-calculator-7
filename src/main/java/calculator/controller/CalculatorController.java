package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private static String str ="";


    public static void run(){
        inputString();
    }

    public static void inputString(){
        OutputView.startCalculator();
        str = InputView.getInput();
    }
}
