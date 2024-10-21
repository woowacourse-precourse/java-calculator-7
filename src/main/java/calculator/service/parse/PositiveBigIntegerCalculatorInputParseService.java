package calculator.service.parse;

import calculator.exception.NonPositiveNumberException;
import java.math.BigInteger;

public class PositiveBigIntegerCalculatorInputParseService extends BigIntegerCalculatorInputParseService {

    public PositiveBigIntegerCalculatorInputParseService() {
    }

    protected BigInteger parseSumNumber(String numberStr) {
        BigInteger parsedNumber = super.parseSumNumber(numberStr);

        if (parsedNumber.compareTo(BigInteger.ZERO) <= 0) {
            throw new NonPositiveNumberException(parsedNumber);
        }

        return parsedNumber;
    }
}
