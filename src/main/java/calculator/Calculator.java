package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final String argument;

    public Calculator(String argument) {
        this.argument = argument;
    }

    public BigInteger calculate() {
        return addElements(parse());
    }

    private List<BigInteger> parse() {
        String expression = argument;
        String delimiter = "[,:]";
        List<BigInteger> result = new ArrayList<>();
        if (argument.isEmpty()) {
            return result;
        }
        if (argument.startsWith("//")) {
            String[] token = argument.split("\\\\n");
            validateCustomDelimiter(token);
            expression = token[1];
            delimiter = token[0].substring(2, 3);
        }
        String[] operands = expression.split(delimiter);
        validateNumbers(operands);
        for (String operand : operands) {
            result.add(new BigInteger(operand));
        }
        return result;
    }

    private static void validateNumbers(String[] operands) {
        try {
            for (String operand : operands) {
                BigInteger number = new BigInteger(operand);
                if (number.compareTo(BigInteger.ZERO) <= 0) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("수 입력값을 파싱할 수 없습니다.");
        }
    }

    private static void validateCustomDelimiter(String[] tokens) {
        if (tokens.length!=2 || tokens[0].length()!=3) {
            throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
        }
    }

    private BigInteger addElements(List<BigInteger> elements) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger element: elements) {
            sum = sum.add(element);
        }
        return sum;
    }


}
