package calculator;

public class InputValidator {

    public boolean hasInput(String input) {
        return input == null || input.isBlank();
    }

    public void isNegativeNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(
                ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
        }
    }
}
