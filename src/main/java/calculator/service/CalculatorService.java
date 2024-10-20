package calculator.service;

import calculator.utils.Validator;

public class CalculatorService {
    private String[] tokens;

    public void separate(String[] separators, String expression) {
        String cleanedExpression = expression.replaceAll("\\s+", "");
        this.tokens = cleanedExpression.split(String.join("|", separators));
        validateIsNumber(tokens);
    }

    private void validateIsNumber(String[] tokens) {
        Validator.isNumber(tokens);
    }
}
