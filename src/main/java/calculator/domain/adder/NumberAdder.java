package calculator.domain.adder;

import calculator.domain.parser.InputParser.ParsedInput;
import java.math.BigDecimal;

public class NumberAdder {

    public String adder(ParsedInput parsedInput) {
        BigDecimal result = BigDecimal.ZERO;
        for (String numberToken : parsedInput.numbersToken()) {
            BigDecimal num = new BigDecimal(numberToken);
            result = result.add(num);
        }

        return result.toPlainString();
    }

}
