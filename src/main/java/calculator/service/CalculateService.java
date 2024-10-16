package calculator.service;

import java.math.BigInteger;
import java.util.List;

public class CalculateService {
    private static CalculateService instance;

    private CalculateService() {
    }

    public static CalculateService getInstance() {
        if (instance == null) {
            instance = new CalculateService();
        }
        return instance;
    }

    //계산
    public String calculate(List<String> numbers) {
        BigInteger answer = numbers.stream()
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);
        return answer.toString();
    }
}
