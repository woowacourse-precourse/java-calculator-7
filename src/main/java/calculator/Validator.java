package calculator;

public abstract class Validator {

    public static int validateIfInputNotNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validateIfInputNegative(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIfInputNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}
