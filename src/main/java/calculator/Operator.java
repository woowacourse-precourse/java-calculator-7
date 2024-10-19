package calculator;

import java.math.BigInteger;
import java.util.List;

public class Operator {
    public BigInteger add(List<BigInteger> operands) {
        BigInteger result = BigInteger.ZERO;
        for (BigInteger operand : operands) {
            result = result.add(operand);
        }
        return result;
    }
}
