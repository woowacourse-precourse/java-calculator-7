package calculator.domain;

import calculator.domain.handler.InputHandler;

public class CalculatorController {
    private final InputHandler inputHandler;


    public CalculatorController() {
        this.inputHandler = new InputHandler();
    }

    public void run() {
        String input = inputHandler.getInput();
    }
}
