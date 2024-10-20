package calculator.service;

import calculator.domain.BigIntegerCalculator;
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

        return stringAdd(splitStringArr);
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

    private String stringAdd(String[] splitStringArr) {
        Calculator calculator = new Calculator();
        try {
            for (String s : splitStringArr) {
                inputValidator.validateIsNumber(s);

                calculator.add(s);
            }
        } catch (NumberFormatException e) {
            return stringAddBig(splitStringArr);
        }
        return calculator.getResult();
    }

    private String stringAddBig(String[] splitStringArr) {
        BigIntegerCalculator calculator = new BigIntegerCalculator();
        for (String s : splitStringArr) {
            inputValidator.validateIsNumber(s);

            calculator.add(s);
        }
        return calculator.getResult();
    }

    private String[] stringParse(String input) {
        return StringParser.split(input);
    }
}
