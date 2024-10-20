package calculator.model;

import calculator.exception.ExceptionMessages;

public class CalculatorModel {
    public int add(String[] numbers) {
        int sum = 0;

        if (numbers == null) {
            return sum;
        }

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            if (num <= 0) {
                throw new IllegalArgumentException(ExceptionMessages.NEGATIVE_NUMBER_ERROR);
            }

            sum += num;
        }

        return sum;
    }
}