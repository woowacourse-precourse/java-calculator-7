package calculator.service;

import calculator.domain.Calculator;
import calculator.util.StringParser;
import calculator.validator.InputValidator;

public class StringAddCalculatorService {

    private final InputValidator inputValidator;

    public StringAddCalculatorService(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String add(String input) {
        String number = validateEmptyAndNumber(input);
        if (number != null) {
            return number;
        }

        String[] splitStringArr = stringParse(input);

        Calculator calculator = new Calculator();

        return stringAdd(splitStringArr, calculator);
    }

    private String validateEmptyAndNumber(String input) {
        if (input.isEmpty()) {
            return "0";
        }

        if (input.matches("\\d+")) {
            return input;
        }
        return null;
    }

    private String stringAdd(String[] splitStringArr, Calculator calculator) {
        for (String s : splitStringArr) {
            inputValidator.validateIsNumber(s);
            inputValidator.validateIsLong(s);

            long num = Long.parseLong(s);
            calculator.add(num);

        }
        return calculator.getResult();
    }

    private String[] stringParse(String input) {
        return StringParser.split(input);
    }
}
