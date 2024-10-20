package calculator.model;

public class NumberParser {
    public int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            String trimmedNumber = number.trim();
            if (trimmedNumber.isEmpty()) {
                continue; // 공백 숫자는 무시
            }
            int num = parseNumber(trimmedNumber);
            validatePositive(num);
            sum += num;
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
        }
    }

    private static void validatePositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
    }
}
