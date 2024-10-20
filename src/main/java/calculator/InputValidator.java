package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final long emptyNumber = 0L;

    public static List<Long> validateInput(String[] numbers) {
        List<Long> validNumbers = new ArrayList<>();

        for (String number : numbers) {
            if (number.isEmpty()) {
                validNumbers.add(emptyNumber);
                return validNumbers;
            }
            long validNumber = validateDelimiters(number);
            validatePositiveNumbers(validNumber);
            validNumbers.add(validNumber);
        }
        return validNumbers;
    }

    private static long validateDelimiters(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 구분자 입니다.");
        }
    }

    private static void validatePositiveNumbers(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수 또는 0은 입력할 수 없습니다.");
        }
    }
}
