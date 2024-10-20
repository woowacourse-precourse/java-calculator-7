package calculator;

import calculator.splitter.Splitter;
import calculator.validator.Validator;
import java.math.BigDecimal;

public class StringCalculator {

    private final Splitter splitter;
    private final Validator validator;

    private StringCalculator(Splitter splitter, Validator validator) {
        this.splitter = splitter;
        this.validator = validator;
    }

    public static StringCalculator create(Splitter splitter, Validator validator) {
        return new StringCalculator(splitter, validator);
    }

    public String add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "0";
        }

        String[] tokens = splitter.split(input);
        validator.validate(tokens);
        return sum(tokens);
    }

    private String sum(String[] tokens) {
        BigDecimal total = BigDecimal.ZERO;

        for (String token : tokens) {
            BigDecimal number = new BigDecimal(token);
            total = total.add(number);
        }

        return total.toString();
    }
}
