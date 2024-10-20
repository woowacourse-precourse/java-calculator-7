package calculator.domain;

import calculator.domain.parser.InputParser.ParsedInput;
import java.math.BigDecimal;

public class Calculator {

    public String calculate(ParsedInput parsedInput) {
        BigDecimal result = BigDecimal.ZERO;
        for (String numStr : parsedInput.numbers()) {
            BigDecimal num = new BigDecimal(numStr);
            result = result.add(num);
        }

        return result.toPlainString();
    }

}
