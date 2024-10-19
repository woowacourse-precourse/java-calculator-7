package calculator;

public class NumberValidator {
    void validateNumbers(String[] delimitedNumbers) {
        for (String delimitedNumber : delimitedNumbers) {
            validatePositiveNumber(delimitedNumber);
        }
    }

    private static void validatePositiveNumber(String Number) {
        if (!Number.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException();
        }
    }
}
