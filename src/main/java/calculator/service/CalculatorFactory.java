package calculator.service;

import calculator.service.parser.NumbersParser;
import calculator.service.parser.QueryParser;

public record CalculatorFactory() {
    private static final QueryParser queryParser = new QueryParser();
    private static final NumbersParser numbersParser = new NumbersParser();

    public static Calculator createCalculator() {
        return new Calculator(queryParser, numbersParser);
    }
}
