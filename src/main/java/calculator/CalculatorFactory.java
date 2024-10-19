package calculator;

import calculator.extractor.StringSplitterImpl;
import calculator.converter.NumberConverterImpl;

public class CalculatorFactory {

    public static StringCalculator createCalculator() {
        return new StringCalculator(
                new StringSplitterImpl(),
                new NumberConverterImpl()
        );
    }
}
