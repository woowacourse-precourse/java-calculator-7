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
            throw new IllegalArgumentException("음수는 허용되지 않습니다. 문제가 되는 입력값: " + negativeNumbers);
        }
    }

    public static void validateZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("0은 허용되지 않습니다. 문제가 되는 입력값: [0]");
        }
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다. 문제가 되는 입력값: [" + input + "]");
        }
    }
}
