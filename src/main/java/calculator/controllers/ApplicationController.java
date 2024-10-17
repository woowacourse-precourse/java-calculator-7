package calculator.controllers;

import calculator.controllers.utils.InputValidator;
import calculator.models.NumberModel;
import calculator.models.SeparatorModel;
import calculator.views.ApplicationView;

public class ApplicationController {
    private static final SeparatorModel separatorModel = new SeparatorModel();
    private static final String CUSTOM_PREFIX = "/";
    private static final String ERROR_MSG = "잘못된 입력 형식입니다.";

    public static void run() {
        String userInput = ApplicationView.getInput();

        validateInput(userInput);

        if (userInput.startsWith(CUSTOM_PREFIX)) {
            separatorModel.addSeparator(userInput);
            userInput = separatorModel.removeCustomPrefix((userInput));
        }

        String separatorRegex = separatorModel.getRegex();
        int sum = NumberModel.getSum(userInput, separatorRegex);

        ApplicationView.printOutput(sum);
    }

    private static void validateInput(String input) {
        boolean isValidInput = InputValidator.isValid(input);
        if (!isValidInput) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }
}
