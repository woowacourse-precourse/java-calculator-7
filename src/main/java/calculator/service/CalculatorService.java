package calculator.service;

import calculator.utils.Validator;

public class CalculatorService {
    private String[] tokens;

    public void separate(String[] separators, String expression) {
        String cleanedExpression = expression.replaceAll("\\s+", "");
        this.tokens = cleanedExpression.split(String.join("|", separators));
        validateIsNumber(tokens);
        validateIsPositiveNumber(tokens);
    }

    private void validateIsNumber(String[] tokens) {
        Validator.isNumber(tokens);
    }

    private void validateIsPositiveNumber(String[] tokens) {
        Validator.isPositiveNumber(tokens);
    }

}
