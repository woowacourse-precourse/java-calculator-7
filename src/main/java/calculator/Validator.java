package calculator;

public class Validator {
    public static boolean isValidCustomDelimiter(String input) {
        return true;
    }

    public static boolean isValidDefaultDelimiterString(String input) {
        for (char c : input.toCharArray()) {
            if (c != '-' && c != '+' &&
                c != ',' && c != ':' &&
                Character.isDigit(c) == false)
                return false;
        }
        return true;
    }

    public static boolean isValidCustomDelimiterString(String input) {
        return true;
    }
}