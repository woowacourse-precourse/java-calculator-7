package calculator.domain;

import calculator.domain.parser.InputParser.ParsedInput;
import calculator.dto.CalculatorResponseDto;
import java.math.BigInteger;

public class Calculator {

    public CalculatorResponseDto calculate(ParsedInput parsedInput) {
        BigInteger result = BigInteger.ZERO;
        for (String numStr : parsedInput.numbers()) {
            BigInteger num = new BigInteger(numStr);
            result = result.add(num);
        }

        return new CalculatorResponseDto(result.toString());
    }

}
