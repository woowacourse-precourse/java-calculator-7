package calculator.domain;

import static calculator.global.exception.ErrorMessage.EMPTY_NUMBERS_INPUT;

import calculator.global.exception.CalculatorException;

public class SumCalculator {
    public int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            validateNumbers(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    //    빈 값 처리
    private void validateNumbers(String number) {
        if (number == null || number.isEmpty()) {
            throw CalculatorException.of(EMPTY_NUMBERS_INPUT);
        }
    }

}
