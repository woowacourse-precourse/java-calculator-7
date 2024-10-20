package calculator.model;

import calculator.exception.FactorException;
import java.util.List;

public class Calculator {

    public static int operate(List<Integer> numbers) {
        int result = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (result < 0) {
            throw new FactorException("결과값이 표현 가능한 범위가 아닙니다.");
        }

        return result;
    }
}
