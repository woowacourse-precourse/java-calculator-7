package calculator;

public class GetNumException {
    public static boolean isNotNumber (String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static boolean isNegative (String str) {
        return str.contains("-");
    }
}
