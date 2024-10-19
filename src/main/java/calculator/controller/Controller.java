package calculator.controller;

import calculator.model.Model;
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
        if (Model.isCheckNullOrEmpty(userInput)) {
            return 0;
        }
        Model.isContainZero(userInput);
        if (userInput.startsWith(CUSTOM_DELIMITER_FORWARD.getValue())) {
            return Model.getSum(Model.customDelimiterAddCalculator(userInput));
        }
        return Model.getSum(Model.defaultDelimiterAddCalculator(userInput));
    }

    public void run() {
        String userInput = inputView.readUserInput();
        try {
            int result = calculate(userInput);
            outputView.showResultMessage(result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
