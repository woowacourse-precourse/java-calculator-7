package calculator.service;

import calculator.model.NumberSumCalculator;
import calculator.validator.DelimiterNumberValidator;

import java.util.List;

public class CalculatorService {

    private final DelimiterService delimiterService;
    private final DelimiterNumberValidator delimiterNumberValidator;

    public CalculatorService(DelimiterService delimiterService, DelimiterNumberValidator delimiterNumberValidator) {
        this.delimiterService = delimiterService;
        this.delimiterNumberValidator = delimiterNumberValidator;
    }

    public int calculateSum(String input) {
        String[] stringNumbers = delimiterService.splitNumbers(input);
        List<Integer> validNumber = delimiterNumberValidator.isValidNumber(stringNumbers);
        NumberSumCalculator numberSumCalculator = new NumberSumCalculator(validNumber);
        return numberSumCalculator.sum();
    }

}