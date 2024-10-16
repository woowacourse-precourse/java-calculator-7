package calculator.controller;


import calculator.view.InputView;

public class CalculatorController {
    public void start() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
    }
}
