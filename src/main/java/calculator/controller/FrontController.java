package calculator.controller;

import calculator.domain.InputtedString;
import calculator.view.ConsoleInputView;
import calculator.view.InputView;

public class FrontController {
    public static void run() {

        InputView inputView = new ConsoleInputView();
        InputtedString inputtedString = new InputtedString(inputView.getNextLine());


    }
}
