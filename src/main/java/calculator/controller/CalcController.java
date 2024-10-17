package calculator.controller;

import calculator.view.InputView;

public class CalcController {
    private final InputView inputView;

    public CalcController() {
        this.inputView = new InputView();
    }

    public void run() {
        String inputString = getInput();
        System.out.println("inputString = " + inputString);
    }

    public String getInput() {
        return inputView.getInputString();
    }
}
