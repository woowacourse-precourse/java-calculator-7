package calculator.domain.service;

import calculator.domain.vo.delimiter.Delimiters;
import calculator.domain.vo.number.Numbers;
import java.math.BigInteger;

public class AdditionService {

    public BigInteger compute(String input) {
        Delimiters delimiters = Delimiters.from(input);
        Numbers numbers = delimiters.extractNumbers(input);

        return numbers.reduce();
    }
}
