package calculator.service;

import calculator.service.parse.BigIntegerCalculatorInputParseService;
import java.math.BigInteger;
import java.util.List;

public class BigIntegerCalculatorService implements CalculatorService {

    BigIntegerCalculatorInputParseService bigIntegerCalculatorInputParseService;

    public BigIntegerCalculatorService(BigIntegerCalculatorInputParseService bigIntegerCalculatorInputParseService) {
        this.bigIntegerCalculatorInputParseService = bigIntegerCalculatorInputParseService;
    }

    @Override
    public BigInteger sum(String input) {
        List<BigInteger> numbers = bigIntegerCalculatorInputParseService.parseSumInput(input);

        return numbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
