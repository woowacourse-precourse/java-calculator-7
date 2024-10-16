package calculator;

import calculator.io.InputHandler;

public class Calculator {
    private final InputHandler inputHandler;

    public Calculator(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        String userInput = inputHandler.getUserInput();
        String[] inputNumbers = splitUserInput(userInput, "[,;]");
    }

    private String[] splitUserInput(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }
}
