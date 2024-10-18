package calculator.controller;

import calculator.domain.Numbers;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.service.Extractor;

public class Calculator {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        String userInput = getUserInput();
        Numbers numbers = extractNumbers(userInput);
        outputHandler.showResultMessageWith(numbers.totalSum());
    }

    private Numbers extractNumbers(String userInput) {
        Extractor extractor = Extractor.from(userInput);
        return extractor.extractNumbers();
    }

    private String getUserInput() {
        outputHandler.showInitialMessage();
        return inputHandler.getUserAction().value();
    }

}
