package calculator.service;

import calculator.constant.Message;
import calculator.model.Expression;
import calculator.model.Operators;
import java.util.LinkedList;

public class CalculateService {
    static public int sequentialAdd(Operators operators, Expression expression) {
        int sum = 0;
        boolean addFlag = true;
        LinkedList<Object> tokens = expression.getExpression();

        for (Object token : tokens) {
            if (token instanceof Integer && addFlag) {
                addFlag = false;
                sum = addExact(sum, (int) token);
            } else if (token instanceof Character && !addFlag && operators.contains((char) token)) {
                addFlag = true;
            } else {
                throw new IllegalArgumentException(Message.CALCULATION_EXCEPTION_MESSAGE);
            }
        }
        if (addFlag) {
            throw new IllegalArgumentException(Message.CALCULATION_EXCEPTION_MESSAGE);
        }

        return sum;
    }

    private static int addExact(int sum, int tokenValue) {
        try {
            return Math.addExact(sum, tokenValue);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(Message.OVERFLOW_EXCEPTION_MESSAGE);
        }
    }
}
