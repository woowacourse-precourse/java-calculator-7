package calculator.calc;

import calculator.splitter.Splitter;

public class Calculator implements Calculatable {

    private final Splitter splitter;

    public Calculator(Splitter splitter) {
        this.splitter = splitter;
    }

    @Override
    public long sumOfString(String exp) {
        String[] numbers = splitter.split(exp);       //커스텀 스플리터로 분리
        long sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum = getSum(numbers, i, numbers[i], sum);
        }
        return sum;
    }

    private static long getSum(String[] numbers, int i, String number, long sum) {
        if (!number.isEmpty()) {
            int num = Integer.parseInt(number.trim());
            if (num >= 0) {
                sum += num;
            } else {
                throw new IllegalArgumentException();
            }
        } else if (i != 0 && i != numbers.length - 1) {
            throw new IllegalArgumentException();
        }
        return sum;
    }
}