package calculator.domain;

import calculator.validator.PositiveIntegerValidator;
import java.util.List;

public class PositiveIntegerConverter {

    private final List<String> splittedExpression;

    public PositiveIntegerConverter(List<String> splittedExpression) {
        PositiveIntegerValidator.validatePositiveIntegers(splittedExpression);
        this.splittedExpression = splittedExpression;
    }

    public List<Double> convertToPositiveNumbers() {
        return splittedExpression.stream()
                .map(Double::parseDouble).toList();
    }
}