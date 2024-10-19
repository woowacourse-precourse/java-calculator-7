package calculator.operations;

import calculator.CalculatorException;

public class AdditionStrategy implements CalculatorStrategy {

    @Override
    public int calculate(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            if (number < 0) {
                throw new CalculatorException("양수만 입력할 수 있습니다.");
            }
            result += number;
        }
        return result;
    }
}
