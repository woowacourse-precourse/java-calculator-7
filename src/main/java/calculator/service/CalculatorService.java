package calculator.service;

import calculator.validator.CalculatorValidator;

public class CalculatorService {

    private final CalculatorValidator calculatorValidator = new CalculatorValidator();

    public boolean haveCustomDelimiter(String inputString) {
        return calculatorValidator.validateCustomDelimiterInput(inputString);
    }
}