package calculator.service;

import calculator.util.StringNumberSumCalculator;

public class CalculatorService {

    private final DelimiterService delimiterService;

    public CalculatorService(DelimiterService delimiterService) {
        this.delimiterService = delimiterService;
    }

    public int calculateSum(String input) {
        String[] numbers = delimiterService.splitNumbers(input);

        return StringNumberSumCalculator.sum(numbers);
    }

}