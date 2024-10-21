package calculator;

import calculator.operator.Operator;
import calculator.parser.Parser;
import calculator.util.BigDecimalArrayConverter;

import java.math.BigDecimal;

public class StringAdditionCalculator implements StringCalculator {

    private final Operator operator;
    private final Parser parser;

    public StringAdditionCalculator(Operator operator, Parser parser) {
        this.operator = operator;
        this.parser = parser;
    }

    @Override
    public BigDecimal calculate(String input) {
        String[] parse = parser.parseToNumberStrings(input);
        BigDecimal[] numbers = BigDecimalArrayConverter.convert(parse);
        return operator.calculate(numbers);
    }
}
