package calculator.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {

    public static void validateNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number < 0) {
                negativeNumbers.add(number);
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다. 입력 값: " + negativeNumbers);
        }
    }
}
