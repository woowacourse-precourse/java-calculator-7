package calculator.config;

import calculator.model.DelimiterParser;
import calculator.model.StringCalculator;
import calculator.model.SumCalculator;

public class CalculatorFactory {

    public static StringCalculator createCalculator(DelimiterParser delimiterParser, SumCalculator sumCalculator) {
        return new StringCalculator(delimiterParser, sumCalculator);
    }
}
