package calculator;

public class Validator {

    public void validate(String[] numbers) {
        for (String number : numbers) {
            if (number.trim().isEmpty()) {
                continue;  // 빈 문자열이나 공백만 있는 문자열은 무시
            }
            int value;
            try {
                value = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
            }
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
            }
        }
    }
}

