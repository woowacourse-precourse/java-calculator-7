package calculator.model;

public class InputValidator {
    public static void validateNumber(String number ){
        if (number.matches(".*[^1-9].*")) {
            throw new IllegalArgumentException("입력이 올바르지 않음.");
        }
    }
}
