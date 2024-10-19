package calculator.controller;


import calculator.view.InputView;


public class CalculatorController {
    private final InputView inputview = new InputView();

    public void run() {
        try {
            String input = inputview.input();

            
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
