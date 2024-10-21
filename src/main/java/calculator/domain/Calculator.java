package calculator.domain;

import calculator.exception.ErrorStatus;
import calculator.exception.ExceptionUtils;
import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static int sum(List<Integer> numbers) {
        try {
            return numbers.stream().reduce(0, Math::addExact);
        } catch (ArithmeticException e) {
            ExceptionUtils.throwIllegalArgumentException(ErrorStatus.ADDITION_OVERFLOW);
            return 0;
        }
    }
}
