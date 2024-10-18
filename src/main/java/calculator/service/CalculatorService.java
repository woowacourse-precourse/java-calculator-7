package calculator.service;

import java.math.BigInteger;
import java.util.List;

public class CalculatorService {

    private final CalculatorInputParseService calculatorInputParseService;

    public CalculatorService(CalculatorInputParseService calculatorInputParseService) {
        this.calculatorInputParseService = calculatorInputParseService;
    }

    public BigInteger sum(String input) {
        List<BigInteger> numbers = calculatorInputParseService.parseSumInput(input);

        return numbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
