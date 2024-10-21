package calculator;

public class Validator {

    public static long validateNumber(String numberStr) {
        try {
            long number = Long.parseLong(numberStr);
            if (number <= 0)
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자열이 올바른 숫자 형식이 아니거나 표현 범위를 벗어났습니다.");
        }
    }
}
