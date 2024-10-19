package calculator.util;

public class IntegerUtils {

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

}