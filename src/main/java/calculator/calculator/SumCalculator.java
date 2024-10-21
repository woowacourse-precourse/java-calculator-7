package calculator.calculator;

import calculator.calculator.utils.NumberExtractor;

public class SumCalculator {

    private final NumberExtractor numberExtractor;

    public SumCalculator(NumberExtractor numberExtractor) {
        this.numberExtractor = numberExtractor;
    }

    public int splitAndSumWith(String source) {
        int[] splitNumbers;
        if (source.startsWith("/")) {
            splitNumbers = numberExtractor.extractNumbersWithCustomSeparator(source);
        } else {
            splitNumbers = numberExtractor.extractNumbersWithDefaultSeparator(source);
        }

        int sum = 0;
        for (int number : splitNumbers) {
            sum += number;
        }
        return sum;
    }
}
