package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatorService calculatorService = new CalculatorService();
    private final int CUSTOM_DELIMITER_INDEX = 2;
    private String delimiter = ",:";

    public void start() {
        outputView.printStart();
        try {
            proceed();
        } catch (IllegalArgumentException error) {
            outputView.printError(error.getMessage());
        } finally {
            end();
        }
    }

    public void proceed() {
        String inputString = inputView.promptString();
        if (calculatorService.haveCustomDelimiter(inputString)) {
            addCustomDelimiter(inputString);
        }
    }

    public void end() {
        outputView.printEnd();
    }

    private void addCustomDelimiter(String inputString) {
        delimiter += inputString.charAt(CUSTOM_DELIMITER_INDEX);
    }
}
