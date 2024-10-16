package calculator.controller;

import calculator.controller.utils.InputValidator;
import calculator.view.ApplicationView;

public class ApplicationController {
    public static void run() {
        String userInput = ApplicationView.getInput();

        boolean isValidInput = InputValidator.isValid(userInput);
        if (!isValidInput) {
            throw new IllegalArgumentException();
        }
    }
}
