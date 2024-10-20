package calculator.adder;

import calculator.delimiter.Delimiter;
import java.math.BigInteger;

public class Adder {
    private final Delimiter delimiter;

    public Adder() {
        this.delimiter = new Delimiter();
    }

    public BigInteger addInput(String input) {
        input = processCustomDelimiter(input);

        if (input.isEmpty()) {
            return BigInteger.ZERO;
        }

        String[] inputList = splitInput(input);
        return calculateSum(inputList);
    }

    private String processCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            input = delimiter.addCustomDelimiter(input);
        }
        return input;
    }

    private String[] splitInput(String input) {
        return input.split(delimiter.getDel());
    }

    private BigInteger calculateSum(String[] inputList) {
        BigInteger sum = BigInteger.ZERO;

        for (String s : inputList) {
            sum = sum.add(parseNum(s));
        }
        return sum;
    }

    private BigInteger parseNum(String s) {
        try {
            BigInteger num = new BigInteger(s);
            validatePositiveNum(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validatePositiveNum(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }
}
