package calculator.calulate;

import java.math.BigInteger;
import java.util.List;

public class Plus {

    public String getResult(List<String> numbers) {
        String result = null;

        try {
            result = String.valueOf(getResultForInteger(numbers));
        } catch (NumberFormatException e) {
            result = getResultForBigInteger(numbers).toString();
        }

        return result;
    }

    public Integer getResultForInteger(List<String> numbers) {
        return numbers.stream().mapToInt(Integer::parseInt).sum();
    }

    public BigInteger getResultForBigInteger(List<String> numbers) {
        return numbers.stream().map(BigInteger::new).reduce(BigInteger.ZERO, BigInteger::add);
    }

}
