package calculator.model;

import java.util.List;

public class Calculator {

    public Long calculate(List<Long> arguments) {
        Long result = 0L;

        try {
            for (Long argument : arguments) {
                result = Math.addExact(result, argument);
            }
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("너무 큰 숫자가 입력되었습니다");
        }

        return result;
    }
}
