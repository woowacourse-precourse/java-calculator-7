package calculator.service;

import java.math.BigInteger;
import java.util.List;

public class CalculateService {
    //계산
    public String calculate(List<String> numbers) {
        BigInteger answer = numbers.stream()
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);
        return answer.toString();
    }
}
