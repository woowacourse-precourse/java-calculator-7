package calculator;

public class Validator {
    public static void validateNegativeNumbers(String[] numbers) {
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
        }
    }
    public static void validateInput(String[] numbers) {
        for (String number : numbers) {
            try {
                Integer.parseInt(number.trim()); // 숫자 변환 시도
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
            }
        }
    }
}
