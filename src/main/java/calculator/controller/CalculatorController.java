package calculator.controller;

import calculator.parser.InputParser;
import calculator.service.CalculateService;
import calculator.service.ChangeService;
import calculator.service.SeparateService;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = InputValidator.getInstance();
    private final InputParser inputParser = InputParser.getInstance();
    private final SeparateService separateService = new SeparateService();
    private final CalculateService calculateService = new CalculateService();
    private final ChangeService changeService = new ChangeService();

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
        inputValidator.validateStrip(input);
        String[] separated = separateService.separate(input);
        changeService.BlankToZero(separated);
        List<Integer> numbers = inputParser.toInteger(separated);
        int sum = calculateService.sum(numbers);
        return Integer.toString(sum);
    }

    private void displayResult(String result) {
        outputView.displayResult(result);
    }
}
