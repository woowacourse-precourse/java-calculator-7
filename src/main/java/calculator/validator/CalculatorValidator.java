package calculator.validator;

public class CalculatorValidator {

    public void validateSeparator(String input) {
        if (input.startsWith("//")) {
            int customSeparatorNextIndex = input.indexOf("\n");

            if (customSeparatorNextIndex == -1) {
                throw new IllegalArgumentException();
            }
            String delimiterPart = input.substring(2, customSeparatorNextIndex);
            if (delimiterPart.length() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateNumberFormat(String number) {
        try {
            int num = Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}
