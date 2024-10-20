package calculator.model;

public class NumberConverter {
    public static int convertToInt(String token) {

        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();

        }
    }
}
