package calculator.validators;

import java.util.List;

public final class NumberValidator {

    private static int ZERO = 0;

    // 모든 값은 양수여야한다.
    public static void numberValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < ZERO) {
                throw new IllegalArgumentException();
            }
        }
    }
}
