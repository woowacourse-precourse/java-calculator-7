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

        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number.trim());
            }
        }

        return sum;
    }
}