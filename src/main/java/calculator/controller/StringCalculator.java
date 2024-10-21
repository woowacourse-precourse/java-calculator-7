package calculator.controller;

import calculator.validator.StringValidator;
import java.math.BigDecimal;
import java.util.List;

public class StringCalculator {

    private final StringValidator validator = new StringValidator();

    public BigDecimal calculateInput(String input) {
        String[] nums = validator.checkDelimiter(input);
        List<BigDecimal> numbers = validator.checkNumber(nums);
        return validator.sumNumber(numbers);
    }
}
