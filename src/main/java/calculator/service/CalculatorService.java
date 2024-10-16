package calculator.service;

import calculator.util.StringNumberSumCalculator;

public class CalculatorService {

    private final DelimiterService delimiterService;

    public CalculatorService(DelimiterService delimiterService) {
        this.delimiterService = delimiterService;
    }

    public int calculateSum(String input) {
        String[] numbers = delimiterService.splitNumbers(input);

        if (numbers.length == 1) {
            return Integer.parseInt(numbers[0]);
        }

        return StringNumberSumCalculator.sum(numbers);
    }

}