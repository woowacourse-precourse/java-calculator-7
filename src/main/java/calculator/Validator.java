package calculator;


public abstract class Validator {

    public static int validateIfInputNegative(int numbers) {
        if (numbers < 0) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public static int validateIfNotNumber(String splitInput) {
        try {
            return Integer.parseInt(splitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
