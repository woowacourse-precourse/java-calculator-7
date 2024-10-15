package calculator.controller;

import calculator.parser.InputParser;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();

    public void run() {
        requestInput();
        String input = receiveInput();
        String result = processInput(input);
    }

    private void requestInput() {
        outputView.requestInput();
    }

    private String receiveInput() {
        return inputView.receiveInput();
    }

    private String processInput(String input) {
        inputValidator.validateStrip(input);
        String[] separated = inputParser.separate(input);
        inputValidator.validateInteger(separated);
        // 임시로 input return
        return input;
    }
}
