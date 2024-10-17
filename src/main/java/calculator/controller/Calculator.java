package calculator.controller;

import calculator.service.Extractor;
import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;

import java.util.List;

public class Calculator {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Extractor extractor;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler, Extractor extractor) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.extractor = extractor;
    }

    public void run() {
        String userInput = getUserInput();

        Delimiters delimiters = Delimiters.from(userInput);
        Numbers numbers = extractNumbers(userInput, delimiters);

        outputHandler.showResultMessageWith(numbers.totalSum());
    }

    private Numbers extractNumbers(String userInput, Delimiters delimiters) {
        String numberPart = extractor.extractNumberPart(userInput, delimiters.isCustomDelimiter());
        List<Integer> extractedNumbers = extractor.extractNumbers(numberPart, delimiters.getRegex());
        return new Numbers(extractedNumbers);
    }

    private String getUserInput() {
        outputHandler.showInitialMessage();
        return inputHandler.getUserAction().value();
    }
}
