package calculator.controller;

import calculator.controller.utils.InputValidator;
import calculator.models.SeparatorModel;
import calculator.view.ApplicationView;

public class ApplicationController {
    private static SeparatorModel separatorModel = new SeparatorModel();

    public static void run() {
        String userInput = ApplicationView.getInput();

        boolean isValidInput = InputValidator.isValid(userInput);
        if (!isValidInput) {
            throw new IllegalArgumentException();
        }

        if (userInput.startsWith("//")) {
            separatorModel.addSeparator(userInput);
        }
    }
}
