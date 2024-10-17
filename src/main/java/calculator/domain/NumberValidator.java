package calculator.domain;

import java.util.List;

public class NumberValidator {

    /**
     * 숫자들이 양수인지 검사
     */
    public static void isPositiveNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
