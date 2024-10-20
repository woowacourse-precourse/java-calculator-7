package calculator.controller;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.io.UserInput;
import calculator.model.InputText;
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
        List<Integer> tokenize = inputText.tokenize();
        int sum = calculateSum(tokenize);
        outputHandler.showCalculatedValue(sum);
    }

    private int calculateSum(List<Integer> tokenize) {
        return tokenize.stream()
                .mapToInt(integer -> integer)
                .sum();
    }
}