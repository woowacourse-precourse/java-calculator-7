package calculator.domain;

import calculator.validator.PositiveIntegerValidator;
import java.util.List;

public class PositiveNumberConverter {

    private final List<String> splittedExpression;

    public PositiveNumberConverter(List<String> splittedExpression) {
        PositiveIntegerValidator.validatePositiveIntegers(splittedExpression);
        this.splittedExpression = splittedExpression;
    }

    public List<Double> convertStringToPositiveNumbers() {
        return splittedExpression.stream()
                .map(Double::parseDouble).toList();
    }
}