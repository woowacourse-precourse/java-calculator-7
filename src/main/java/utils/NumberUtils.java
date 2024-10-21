package utils;

public class NumberUtils {
    public static boolean isPositiveNumber(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isInteger(double number) {
        return number == (int) number;
    }
}
