package calculator.calculator;

import static calculator.exception.ErrorMessage.OUT_OF_RANGE;

import calculator.exception.ExceptionHandler;
import java.util.List;

public class SumCalculator implements Calculator {

    @Override
    public int add(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum = safeAdd(sum, number);
        }
        return sum;
    }

    private static int safeAdd(int a, int b) {
        try {
            return Math.addExact(a, b);
        } catch (ArithmeticException e) {
            ExceptionHandler.throwIllegalArgException(OUT_OF_RANGE);
            return 0; // 도달하지 않음
        }
    }
}
