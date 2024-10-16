package calculator.service;

import calculator.util.StringNumberSumCalculator;

public class CalculatorService {

    private final DelimiterService delimiterService;

    public CalculatorService(DelimiterService delimiterService) {
        this.delimiterService = delimiterService;
    }

    public int calculateSum(String input) {
        return StringNumberSumCalculator.sum(delimiterService.splitNumbers(input));
    }

}