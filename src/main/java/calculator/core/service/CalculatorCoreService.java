package calculator.core.service;

import calculator.converter.StringToPositiveIntegerListConverter;
import calculator.parser.DelimiterParser;

import java.math.BigInteger;
import java.util.List;

import static calculator.util.StringUtils.hasText;
import static java.math.BigInteger.ZERO;

public class CalculatorCoreService {

    private final DelimiterParser parser;
    private final StringToPositiveIntegerListConverter converter;

    public CalculatorCoreService() {
        this.parser = new DelimiterParser();
        this.converter = new StringToPositiveIntegerListConverter();
    }

    public BigInteger sum(String input) {
        if (!hasText(input)) {
            return ZERO;
        }

        List<String> delimiters = parser.getBasicDelimiters();
        String customDelimiter = parser.getCustomDelimiter(input);

        if (hasText(customDelimiter)) {
            delimiters.add(customDelimiter);
            input = parser.replaceCustomDelimiterSyntax(input, customDelimiter);
        }

        BigInteger sum = ZERO;

        for (BigInteger number : converter.convert(input, delimiters)) {
            sum = sum.add(number);
        }

        return sum;
    }
}
