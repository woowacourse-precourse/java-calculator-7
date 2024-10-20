package calculator.model;

import calculator.view.Validator;

public class Calculator {

    public static int sum(String input) {
        if (input.isBlank() || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        String[] numbers = Validator.validateInput(input);

        for (String number : numbers) {
            result += Validator.parseNumber(number);
        }
        return result;
    }
}