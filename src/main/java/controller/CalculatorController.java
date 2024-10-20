package controller;

import model.SaveTokens;
import view.UserInputView;
import view.UserOutputView;

public class CalculatorController {

    private final UserInputView userInputView;
    private final UserOutputView userOutputView;
    private final SaveTokens saveTokens;

    public CalculatorController(UserInputView userInputView, UserOutputView userOutputView, SaveTokens saveTokens) {
        this.userInputView = userInputView;
        this.userOutputView = userOutputView;
        this.saveTokens = saveTokens;
    }

    public void run(){
        String userInput = userInputView.receiveInput();
        userOutputView.printUserOutput(userInput);
        String[] tokens = saveTokens.saveTokens(userInput);
        userOutputView.printTokens(tokens);

    }
}
