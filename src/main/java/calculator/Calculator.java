package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class Calculator {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        outputHandler.showStartComments();
        String userInput = inputHandler.getUserInput();
        outputHandler.printResult(0);
    }
}
