package calculator.model.impl;

import calculator.model.SumCalculator;

public class SumCalculatorImpl implements SumCalculator {

    @Override
    public int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            validateNumber(number);
            int num = Integer.parseInt(number.trim());
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }

    private void validateNumber(String number) {
        try {
            Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 값이 포함되어 있습니다: " + number);
        }
    }
}
