package calculator;

public class Validator {

    public static boolean isValidNumber(String numberStr) {
        try {
            double number = Double.parseDouble(numberStr);
            return number > 0.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
