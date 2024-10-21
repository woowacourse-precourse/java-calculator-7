package calculator.fake;

import calculator.application.ExtractService;
import java.math.BigInteger;
import java.util.List;

public class FakeExtractService implements ExtractService {

    @Override
    public List<BigInteger> extractNumbers(List<String> data) {
        return List.of(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3));
    }

}
