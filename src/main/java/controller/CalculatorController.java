package controller;

import view.UserInputView;
import view.UserOutputView;

public class CalculatorController {

    private final UserInputView userInputView;
    private final UserOutputView userOutputView;

    public CalculatorController(UserInputView userInputView, UserOutputView userOutputView) {
        this.userInputView = userInputView;
        this.userOutputView = userOutputView;
    }

    public void run(){
        String userInput = userInputView.receiveInput();
        userOutputView.printUserOutput(userInput);

    }
}
