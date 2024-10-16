package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public static void run(){
        OutputView.printCommand();
        InputView.enterInput();
    }
}
