package calculator.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {

    public static void validateNumbers(List<Integer> numbers) {
        validateNegativeNumbers(numbers);
        validateZero(numbers);
    }

    public static void validateCustomDelimiter(String delimiter) {
        validateNullOrEmpty(delimiter);
        validateSingleCharacter(delimiter);
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다. 문제가 되는 입력값: [" + input + "]");
        }
    }

    private static void validateNegativeNumbers(List<Integer> numbers) {
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

    private static void validateZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("0은 허용되지 않습니다. 문제가 되는 입력값: [0]");
        }
    }

    private static void validateNullOrEmpty(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }

    private static void validateSingleCharacter(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 구분자는 단일 문자여야 합니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }
}
