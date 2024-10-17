package calculator.service;

import calculator.util.StringNumberSumCalculator;
import calculator.validation.DelimiterNumberValidator;

public class CalculatorService {

    private final DelimiterService delimiterService;
    private final DelimiterNumberValidator delimiterNumberValidator;

    public CalculatorService(DelimiterService delimiterService, DelimiterNumberValidator delimiterNumberValidator) {
        this.delimiterService = delimiterService;
        this.delimiterNumberValidator = delimiterNumberValidator;
    }

    public int calculateSum(String input) {
        String[] stringNumbers = delimiterService.splitNumbers(input);
        int[] numbers = delimiterNumberValidator.isValidNumber(stringNumbers);

        if (numbers.length == 1) {
            return numbers[0];
        }

        return StringNumberSumCalculator.sum(numbers);
    }

}