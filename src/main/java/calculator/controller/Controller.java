package calculator.controller;

import calculator.domain.User;
import calculator.handler.InputHandler;
import calculator.handler.PrintHandler;

public class Controller {
    private final PrintHandler printHandler;
    private final InputHandler inputHandler;


    public Controller() {
        this.printHandler = new PrintHandler();
        this.inputHandler = new InputHandler();
    }


    public void run() {
        printHandler.printStartMessage();
        String tempString = inputHandler.inputString();
        User user = new User(tempString);
    }
}
