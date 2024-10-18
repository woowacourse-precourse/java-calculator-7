package calculator.util;

public class IntegerValidator {
    public void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }

    }
}
