package calculator.util;

public class Validator {

    public static String checkNumeric(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static Integer checkPositive(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
