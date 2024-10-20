package calculator.util;

import calculator.domain.Expression;
import calculator.domain.NumberType;
import java.math.BigInteger;

public class ExpressionParser {
    public static int[] parseExpressionToIntArray(String[] tokens) {
        int[] numbers = new int[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                Validator.validateNumericInput(tokens[i]);
                numbers[i] = Integer.parseInt(tokens[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public static long[] parseExpressionToLongArray(String[] tokens) {
        long[] numbers = new long[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                Validator.validateNumericInput(tokens[i]);
                numbers[i] = Long.parseLong(tokens[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public static BigInteger[] parseExpressionToBigIntegerArray(String[] tokens) {
        BigInteger[] numbers = new BigInteger[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                Validator.validateNumericInput(tokens[i]);
                numbers[i] = new BigInteger(tokens[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public static String[] tokenizeExpression(Expression expression) {
        String expressionString = expression.getExpression();
        String delimiter = expression.getDelimiter();
        return expressionString.split(delimiter);
    }

    public static NumberType getArrayType(String[] tokens) {
        int maxValueSize = 0;
        for (String token : tokens) {
            maxValueSize = Math.max(maxValueSize, token.length());
        }

        int maxSumValueSize = maxValueSize + (tokens.length / 10);
        if (maxSumValueSize < 10) {
            return NumberType.INT;
        } else if (maxSumValueSize < 19) {
            return NumberType.LONG;
        }
        return NumberType.BIGINTEGER;
    }
}
