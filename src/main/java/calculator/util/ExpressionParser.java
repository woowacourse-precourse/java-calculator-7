package calculator.util;

import calculator.domain.Expression;

public class ExpressionParser {
    public static int[] parseExpressionToIntArray (Expression expression) {
        String expressionString = expression.getExpression();
        String delimiter = expression.getDelimiter();

        String[] tokens = expressionString.split(delimiter);
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = validateTokens(tokens[i]);
        }
        return numbers;
    }

    // 토큰이 유효한지 검증하는 메서드
    private static int validateTokens(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Validator.validateNumericInput(token);
    }
}
