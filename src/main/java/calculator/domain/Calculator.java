package calculator.domain;

import calculator.domain.parser.InputParser.ParsedInput;
import java.math.BigInteger;

public class Calculator {

    public String calculate(ParsedInput parsedInput) {
        BigInteger result = BigInteger.ZERO;
        for (String numStr : parsedInput.numbers()) {
            BigInteger num = new BigInteger(numStr);
            result = result.add(num);
        }

        return result.toString();
    }

}
