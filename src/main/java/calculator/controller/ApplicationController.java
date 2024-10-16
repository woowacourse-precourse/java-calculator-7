package calculator.controller;

import calculator.controller.utils.InputValidator;
import calculator.models.NumberModel;
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
            userInput = separatorModel.removeSeparatorPrefix((userInput));
        }

        String separatorRegex = separatorModel.getRegex();
        String[] numbers = userInput.split(separatorRegex);
        int sum = NumberModel.getSum(numbers);

        ApplicationView.printOutput(sum);
    }
}
