package calculator.model;

import java.math.BigInteger;
import java.util.List;

public class Expression {
    private String rawExpression;
    private List<BigInteger> processIntegerList;

    public Expression(String expression) {
        this.rawExpression = expression;
    }

    public String getRawExpression() {
        return this.rawExpression;
    }

    public void processRawExpression(List<Character> separatorList) {
        if (separatorList.size() == 3) {
            processIntegerList = ExpressionParser.getIntegerListFromSeparator(rawExpression.substring(5),
                    separatorList);
        } else if (separatorList.size() == 2) {
            processIntegerList = ExpressionParser.getIntegerListFromSeparator(rawExpression, separatorList);
        }
    }

    public BigInteger getListSum() {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger num : processIntegerList) {
            sum = sum.add(num);
        }
        return sum;
    }
}
