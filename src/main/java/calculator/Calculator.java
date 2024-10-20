package calculator;

import java.math.BigInteger;

public class Calculator {
    private final InputParser parser;

    public Calculator(InputParser parser) {
        this.parser = parser;
    }

    public Number calculateTotalSum() {
        BigInteger totalSum = BigInteger.ZERO;
        String[] numbers = parser.getNumbers();

        for (String num : numbers) {
            BigInteger inputNum = stringToNum(num);
            if (inputNum.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("입력 오류: 양수를 입력해주세요");
                throw new IllegalArgumentException();
            }
            totalSum = totalSum.add(inputNum);
        }
        // 가능하면 int 자료형으로 처리
        if (totalSum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
            return totalSum.intValue();
        }
        return totalSum;
    }

    private BigInteger stringToNum(String number) {
        try {
            if (number.isEmpty()) {
                number = "0";
            }
            return new BigInteger(number.trim());
        } catch (NumberFormatException e) {
            System.out.println("입력 오류: 숫자를 입력해주세요");
            throw new IllegalArgumentException();
        }
    }
}
