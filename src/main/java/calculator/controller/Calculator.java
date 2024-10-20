package calculator.controller;

import calculator.controller.io.InputHandler;
import calculator.controller.io.OutputHandler;
import calculator.controller.io.UserInput;
import calculator.domain.InputText;
import calculator.domain.Tokens;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void calculate() {
        outputHandler.showEntryMessage();
        UserInput userInput = inputHandler.getUserInput();
        InputText inputText = new InputText(userInput.getDelimiter(), userInput.getPlainText());
        Tokens tokens = inputText.tokenize();
        int totalCost = tokens.sum();
        outputHandler.showCalculatedValue(totalCost);
    }
}