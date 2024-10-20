package calculator.operations;

import calculator.CalculatorException;

public class AdditionStrategy implements CalculatorStrategy {

    @Override
    public long calculate(long[] numbers) {
        long result = 0;
        for (long number : numbers) {
            if (number < 0) {
                throw new CalculatorException("양수만 입력할 수 있습니다.");
            }
            result += number;
        }
        return result;
    }
}
