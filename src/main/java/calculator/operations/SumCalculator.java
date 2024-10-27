package calculator.operations;

import calculator.exception.ExceptionUtils;
import calculator.exception.IllegalArgumentExceptionEnum;
import java.util.ArrayList;

public class SumCalculator {
    public SumCalculator() {

    }

    public static int sum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            try {
                sum = Math.addExact(sum, number);
            } catch (Exception e) {
                ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.ADDITION_OVERFLOW);
            }
        }
        return sum;
    }

}
