package calculator.model;

public class NumberConverter {
    public static int convertToInt(String token) {
        InputValidator.validateIsNumber(token);
        try {
            int number = Integer.parseInt(token);
            InputValidator.validateNonNegative(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();

        }
    }
}
