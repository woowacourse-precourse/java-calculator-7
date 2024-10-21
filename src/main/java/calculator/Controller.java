package calculator;

import calculator.service.InputHandler;

public class Controller {
    private final InputHandler inputHandler;

    public Controller() {
        this.inputHandler = new InputHandler();
    }

    public void run(){
        String input = inputHandler.getUserInput();
    }
}
