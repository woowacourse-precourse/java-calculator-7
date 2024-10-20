package calculator.controller;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.io.UserInput;
import calculator.model.InputText;
import calculator.model.Token;
import java.util.List;

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
        List<Token> tokens = inputText.tokenize();
        int sum = calculateSum(tokens);
        outputHandler.showCalculatedValue(sum);
    }

    private int calculateSum(List<Token> tokens) {
        return tokens.stream()
                .mapToInt(Token::getCost)
                .sum();
    }
}