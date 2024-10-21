package calculator.application;

import java.math.BigInteger;
import java.util.List;

public interface ExtractService {

    List<BigInteger> extractNumbers(List<String> data);

}
