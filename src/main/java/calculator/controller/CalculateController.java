package calculator.controller;

import calculator.view.InputView;

public class CalculateController {
    public void calculator(){
        String userInput = new InputView().getUserInput();
        System.out.println("input: " + userInput);
    }
}
