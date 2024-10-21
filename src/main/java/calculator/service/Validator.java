package calculator.service;

public class Validator {
    public void validate(String[] numbers) {
        for (String number : numbers) {
            try {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber <= 0) {
                    throw new IllegalArgumentException("음수 또는 0은 허용되지 않습니다: " + number);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수로 변환할 수 없는 값이 있습니다: " + number, e);
            }
        }
    }
}
