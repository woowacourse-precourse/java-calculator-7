package calculator.Calculator;

import calculator.input.InputValidator;
import calculator.staticValue.RegexPatterns;


public class Calculator {

    private final InputValidator inputValidator;

    private final CalculatorService calculatorService;

    public Calculator(InputValidator inputValidator, CalculatorService calculatorService) {
        this.inputValidator = inputValidator;
        this.calculatorService = calculatorService;
    }

    public int Calculate(String input) {

        if (inputValidator.isInputEmpty(input)) {
            return 0;
        }

        if (inputValidator.matchesPattern(input, RegexPatterns.CUSTOM_SEPARATOR.getValue())) {
            String[] splitInputs = calculatorService.SplitInputBySeparators(
                    input);
            return calculateAvailableInput(splitInputs);
        }

        String[] splitInputByBasicSeparators = input.split(RegexPatterns.BASIC_SEPARATORS.getValue());
        return calculateAvailableInput(splitInputByBasicSeparators);
    }

    private int calculateAvailableInput(String[] splitInputs) {
        inputValidator.validateInput(splitInputs);
        return calculatorService.calculateSum(splitInputs);
    }

}
