package calculator.validators;

import java.util.List;

public final class NumberValidator {

    // 모든 값은 양수여야한다.
    public static void numberValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
