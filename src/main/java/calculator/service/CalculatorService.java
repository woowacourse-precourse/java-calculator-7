package calculator.service;

import calculator.domain.Expression;
import calculator.domain.NumberType;
import calculator.util.ExpressionParser;
import calculator.util.InputUtils;
import java.math.BigInteger;

public class CalculatorService {
    public String sum(String input) {
        Expression expression = InputUtils.convertToExpression(input);
        String[] tokens = ExpressionParser.tokenizeExpression(expression);
        NumberType numberType = ExpressionParser.getArrayType(tokens);
        if (numberType == NumberType.INT) {
            return sumIntArray(ExpressionParser.parseExpressionToIntArray(tokens));
        } else if (numberType == NumberType.LONG) {
            return sumLongArray(ExpressionParser.parseExpressionToLongArray(tokens));
        }
        return sumBigIntegerArray(ExpressionParser.parseExpressionToBigIntegerArray(tokens));
    }

    private String sumIntArray (int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return String.valueOf(sum);
    }

    private String sumLongArray (long[] numbers) {
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        return String.valueOf(sum);
    }

    private String sumBigIntegerArray (BigInteger[] numbers) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger number : numbers) {
            sum = sum.add(number);
        }
        return String.valueOf(sum);
    }
}
