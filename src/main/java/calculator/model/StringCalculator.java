package calculator.model;

import calculator.view.InputValidator;

public class StringCalculator {
    public static int sum(String input) {

        if (input.isEmpty() || input.isBlank()) {
            return 0;
        }
        String delimiter = InputValidator.extractDelimiter(input);
        String[] numbers = InputValidator.validateNumbers(input, delimiter).split(delimiter);

        int sum = 0;
        for (String numStr : numbers) {
            sum += Integer.parseInt(numStr.trim());
        }
        return sum;
    }
}

