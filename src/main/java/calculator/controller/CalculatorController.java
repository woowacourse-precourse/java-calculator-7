package calculator.controller;

import calculator.model.CustomCalculator;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private int index = -1;

    public void run() {
        OutputView.printInputStringMessage();

        String input = InputView.readInputString();

        InputValidator.validateInput(input);

        if (input.isEmpty()) {
            OutputView.printResult(0);
            return;
        }

        String separator = findSeparator(input);

        String[] numbers = extractNumbers(input, separator);
        CustomCalculator customCalculator = new CustomCalculator(numbers);

        customCalculator.calculateSum();

        OutputView.printResult(customCalculator.getResult());
    }

    private String findSeparator(String input) {
        if (input.startsWith("//")) {
            index = input.indexOf("\\n");

            return input.substring(2, index);
        }

        return "[,:]";
    }

    private String[] extractNumbers(String input, String separator) {
        if (index >= 0) {
            return input.substring(index + 2).split(separator);
        }

        return input.split(separator);
    }
}
