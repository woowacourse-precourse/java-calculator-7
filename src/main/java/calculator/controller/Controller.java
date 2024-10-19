package calculator.controller;

import calculator.model.Calculate;
import calculator.validation.DelimiterValidator;
import calculator.validation.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

import static calculator.constants.DelimiterEnum.CUSTOM_DELIMITER_FORWARD;


public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private int calculate(String userInput) {
        if (InputValidator.isCheckEmpty(userInput)) {
            return 0;
        }
        if (userInput.startsWith(CUSTOM_DELIMITER_FORWARD.getValue())) {
            return Calculate.calculateTotalSum(DelimiterValidator.customDelimiterAddCalculator(userInput));
        }
        return Calculate.calculateTotalSum(DelimiterValidator.defaultDelimiterAddCalculator(userInput));
    }

    public void run() {
        String userInput = inputView.readUserInput();
        int result = calculate(userInput);
        outputView.showResultMessage(result);
    }
}