package calculator.controller;

import calculator.controller.io.InputHandler;
import calculator.controller.io.OutputHandler;
import calculator.controller.io.UserInput;
import calculator.domain.InputText;
import calculator.domain.Tokens;

public class Calculator {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void calculate() {
        outputHandler.showEntryMessage();
        UserInput userInput = inputHandler.getUserInput();
        InputText inputText = new InputText(userInput.getDelimiter(), userInput.getPlainText());
        Tokens tokens = inputText.tokenize();
        int totalCost = tokens.sum();
        outputHandler.showCalculatedValue(totalCost);
    }
}