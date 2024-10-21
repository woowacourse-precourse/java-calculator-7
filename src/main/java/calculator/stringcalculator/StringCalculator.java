package calculator.stringcalculator;

import java.math.BigDecimal;
import java.util.List;

public class StringCalculator {

    private final StringValidator stringValidator = new StringValidator();
    private final DelimiterHandler delimiterHandler = new DelimiterHandler();
    private final SumCalculator sumCalculator = new SumCalculator();

    public BigDecimal calculateInput(String input) {
        String[] nums = delimiterHandler.checkDelimiter(input);
        List<BigDecimal> numbers = stringValidator.checkNumber(nums);
        return sumCalculator.sumNumber(numbers);
    }
}