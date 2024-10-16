package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.InputHandler;

public class Calculator {
    private final InputHandler inputHandler = new ConsoleInputHandler();
    public void run() {
        String userInput = inputHandler.getUserInput();
    }
}
