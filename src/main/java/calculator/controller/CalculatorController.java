package calculator.controller;

import calculator.UserInputString;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        OutputView.printStartMessage();
        String inputStringForAddition = InputView.readInputString();

        UserInputString userInput = new UserInputString(inputStringForAddition);
        if (userInput.isInputEmpty()) {
            OutputView.printResult("0");
            return;
        }


    }
}
