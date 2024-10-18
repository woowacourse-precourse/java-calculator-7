package calculator.Utils;

public class NumberUtils {

    NumberUtils() {

    }

    public static void isDouble(String number) {
        try {
            Double.parseDouble(number);
        } catch (IllegalArgumentException e) {

        }
    }

    public static boolean isInt(Double number) {
        return number == (long) (double) number;
    }
}
