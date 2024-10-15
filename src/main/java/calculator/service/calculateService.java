package calculator.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class calculateService {
    //계산
    public String calculate(List<String> numbers){
        BigInteger answer = BigInteger.ZERO;
        numbers.stream().map(num -> answer.add(new BigInteger(num)));
        return answer.toString();
    }
}
