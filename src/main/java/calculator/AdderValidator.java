package calculator;

public class AdderValidator {

    public void validate(int num) {

    }

    public void validatePositiveNumber(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("양수만 계산 가능합니다.");
        }
    }
}
