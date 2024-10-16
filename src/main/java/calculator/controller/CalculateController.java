package calculator.controller;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.io.UserInput;

import java.util.Arrays;

public class CalculateController {

    private static final String NUMERIC_REGEX = "[0-9]+";

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Numbers numbers;

    public CalculateController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.numbers = new Numbers();
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void initialize() {
        outputHandler.showInitialMessage();
    }

    public void run() {
        String userInput = getUserAction().value();
        Delimiters delimiters = Delimiters.fromInput(userInput);
        extractNumbers(userInput, delimiters);
        showResult();
    }

    private UserInput getUserAction() {
        return inputHandler.getUserAction();
    }

    private void extractNumbers(String userInput, Delimiters delimiters) {
        userInput = extractString(userInput, delimiters);
        if (doesInputContainsDelimiter(userInput, delimiters)) {
            String[] extractNumberString = userInput.split(delimiters.getRegex());
            addNumbersTo(extractNumberString);
            return;
        }
        numbers.addNumber(Integer.parseInt(userInput));
    }

    private boolean doesInputContainsDelimiter(String userInput, Delimiters delimiters) {
        return userInput.contains(delimiters.getRegex());
    }

    private String extractString(String userInput, Delimiters delimiters) {
        if (delimiters.isCustomDelimiter()) {
            userInput = userInput.split("\\\\n")[1];
        }
        return userInput;
    }

    private void addNumbersTo(String[] extractNumberString) {
        Arrays.stream(extractNumberString)
            .filter(this::isPositiveNumber)
            .map(Integer::parseInt)
            .forEach(numbers::addNumber);
    }

    private boolean isPositiveNumber(String s) {
        if (s.matches(NUMERIC_REGEX)) {
            return true;
        }
        throw new IllegalArgumentException("양수와 구분자만 입력 가능합니다.");
    }

    private void showResult() {
        outputHandler.showResultMessage(numbers.totalSum());
    }

}
