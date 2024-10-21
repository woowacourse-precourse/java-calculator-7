package calculator;

import java.util.List;

public class ExceptionLogic {
    public static void validateInput(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 허용되지 않습니다.");
        }

        for (String number : numbers) {
            String trimmedNumber = number.trim();
            if (!trimmedNumber.isEmpty()) {
                validateNumber(trimmedNumber);
            }
        }
    }

    private static void validateNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 형식입니다: " + number);
        }
    }
}