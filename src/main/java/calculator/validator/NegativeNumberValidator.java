package calculator.validator;

public class NegativeNumberValidator {
    public static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 유효한 입력이 아닙니다: " + "\"" + number + "\"");
        }
    }
}
