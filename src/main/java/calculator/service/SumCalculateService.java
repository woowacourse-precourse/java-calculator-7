package calculator.service;

import calculator.domain.Calculator;
import calculator.exception.CalculatorException;

public class SumCalculateService {

    public int calculateSum(Calculator calculator) {
        int sum = 0;
        for (String number : calculator.getNumbers()) {
            int parsedInt = parseInt(number);
            validateNegativeNumber(parsedInt);
            sum += parsedInt;
        }
        return sum;
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new CalculatorException("잘못된 값을 입력하였습니다.");
        }
    }

    private void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new CalculatorException("음수는 허용되지 않습니다: " + number);
        }
    }
}
