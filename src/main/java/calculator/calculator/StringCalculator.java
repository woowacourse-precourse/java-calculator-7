package calculator.calculator;

import calculator.extractor.NumberExtractor;

public class StringCalculator extends Calculator {
    private NumberExtractor numberExtractor;

    public StringCalculator(NumberExtractor numberExtractor) {
        this.numberExtractor = numberExtractor;
    }
}
