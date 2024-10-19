package calculator.controller;

import calculator.model.PositiveNumbers;
import calculator.parser.InputParser;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();

    public void run() {
        requestInput();
        String input = receiveInput();
        String result = processInput(input);
        displayResult(result);
    }

    private void requestInput() {
        outputView.requestInput();
    }

    private String receiveInput() {
        return inputView.receiveInput();
    }

    private String processInput(String input) {
        String[] separated = separate(input);
        int sum = calculateSum(separated);
        return Integer.toString(sum);
    }

    private void displayResult(String result) {
        outputView.displayResult(result);
    }

    private String[] separate(String input) {
        inputValidator.validateStrip(input);
        return inputParser.separate(input);
    }

    private int calculateSum(String[] separated) {
        changeBlankToZero(separated);
        List<Integer> numbers = inputParser.toInteger(separated);
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        return positiveNumbers.sum();
    }

    private void changeBlankToZero(String[] separated) {
        inputValidator.validateZero(separated);
        inputParser.blankToZero(separated);
        inputValidator.validateInteger(separated);
    }
}
