package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.User;
import calculator.handler.InputHandler;
import calculator.handler.PrintHandler;

public class Controller {
    private final PrintHandler printHandler;
    private final InputHandler inputHandler;
    private final Calculator calculator;


    public Controller() {
        this.printHandler = new PrintHandler();
        this.inputHandler = new InputHandler();
        this.calculator = new Calculator();
    }


    public void run() {
        printHandler.printStartMessage();
        String tempString = inputHandler.inputString();
        User user = new User(tempString);
        int sum = calculator.sum(user.getNumbers());
    }
}
