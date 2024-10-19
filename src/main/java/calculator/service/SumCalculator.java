package calculator.service;

import static calculator.constant.ErrorMessage.INVALID_INPUT;
import static calculator.constant.ErrorMessage.NEGATIVE_NUMBER;

import calculator.model.StringExpression;
import calculator.model.SumResult;
import calculator.validation.Validator;
import java.util.Arrays;

public class SumCalculator {
    public SumResult calculate(StringExpression expression) {
        Validator validator = ValidatorFactory.getValidator(StringExpression.class);
        validator.validate(expression);

        int sum = Arrays.stream(expression.split())
                .mapToInt(this::parseNumber)
                .peek(number -> ValidatorFactory.getValidator(Integer.class).validate(number))
                .sum();

        return new SumResult(sum);
    }

    private int parseNumber(String numberString) {
        if (numberString.isEmpty()) {
            return 0;
        }
        try {
            int number = Integer.parseInt(numberString);
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
