package controller;

import model.Calculator;
import model.SaveTokens;
import view.UserInputView;
import view.UserOutputView;

public class CalculatorController {

    private final UserInputView userInputView;
    private final UserOutputView userOutputView;
    private final SaveTokens saveTokens;
    private final Calculator calculator;

    public CalculatorController(UserInputView userInputView, UserOutputView userOutputView, SaveTokens saveTokens, Calculator calculator) {
        this.userInputView = userInputView;
        this.userOutputView = userOutputView;
        this.saveTokens = saveTokens;
        this.calculator = calculator;
    }

    public void run(){
        String userInput = userInputView.receiveInput();
        userOutputView.printUserOutput(userInput);
        String[] tokens = saveTokens.saveTokens(userInput);
        userOutputView.printTokens(tokens);
        userOutputView.printResult(calculator.operationAdd(tokens));

    }
}
