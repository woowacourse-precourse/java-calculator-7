package calculator;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class StringSumCalculator {
    private final InputValidator validator;
    private final StringParser parser;

    public StringSumCalculator(InputValidator validator, StringParser parser) {
        this.validator = validator;
        this.parser = parser;
    }

    public int add(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        String[] numbers = parser.splitNumbers(input);

        int sum = 0;
        for (String number : numbers) {
            String trim = number.trim();
            validator.validateInput(trim);
            sum += validator.positiveNumber(Integer.parseInt(trim));
        }
        return sum;
    }

}