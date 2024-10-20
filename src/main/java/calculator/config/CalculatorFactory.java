package calculator.config;

import calculator.model.DelimiterParser;
import calculator.model.StringCalculator;
import calculator.model.SumCalculator;
import calculator.model.impl.DelimiterParserImpl;
import calculator.model.impl.SumCalculatorImpl;

public class CalculatorFactory {

    public static StringCalculator createCalculator() {
        DelimiterParser delimiterParser = new DelimiterParserImpl();
        SumCalculator sumCalculator = new SumCalculatorImpl();
        return new StringCalculator(delimiterParser, sumCalculator);
    }
}
