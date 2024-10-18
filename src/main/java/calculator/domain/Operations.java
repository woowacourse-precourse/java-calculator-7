package calculator.domain;

import java.math.BigInteger;
import java.util.List;

public class Operations {
    public String add(List<Number> numbers) {
        BigInteger result = BigInteger.ZERO;
        for (Number number : numbers) {
            result = result.add(number.getValue());
        }
        return result.toString();
    }
}
