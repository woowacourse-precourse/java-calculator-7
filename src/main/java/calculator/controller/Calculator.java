package calculator.controller;

import calculator.input.InputValidator;
import calculator.staticValue.RegexPatterns;


public class Calculator {

    private static final InputValidator inputValidator = new InputValidator();

    private static final CalculatorService calculatorController = new CalculatorService();


    public int Calculate(String input) {

        if (inputValidator.isInputEmpty(input)) {
            return 0;
        }

        if (inputValidator.matchesPattern(input, RegexPatterns.CUSTOM_SEPARATOR.getValue())) {
            String[] splitInputs = calculatorController.SplitInputBySeparators(
                    input);
            return calculateAvailableInput(splitInputs);
        } else {
            String[] splitInputByBasicSeparators = input.split(RegexPatterns.BASIC_SEPARATORS.getValue());
            return calculateAvailableInput(splitInputByBasicSeparators);
        }
    }

    private int calculateAvailableInput(String[] splitInputs) {
        inputValidator.validateInput(splitInputs);
        return calculatorController.calculateSum(splitInputs);
    }

}
